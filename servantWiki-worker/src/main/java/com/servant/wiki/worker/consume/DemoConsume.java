package com.servant.wiki.worker.consume;

import java.net.InetSocketAddress;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Component;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.common.utils.AddressUtils;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import com.alibaba.otter.canal.protocol.Message;
import com.servant.wiki.worker.manager.RedisManager;
import com.servant.wiki.worker.task.redis.WriteTask;

@Component
public class DemoConsume implements ApplicationRunner {

	static Logger logger = LoggerFactory.getLogger(DemoConsume.class);

	@Autowired
	private RedisManager redisManager;

	public void run(ApplicationArguments arg0) throws Exception {
		CanalConnector connector = CanalConnectors
				.newSingleConnector(new InetSocketAddress(AddressUtils.getHostIp(), 11111), "example", "", "");

		int batchSize = 1000;

		try {
			connector.connect();
			connector.subscribe(".*\\..*");
			connector.rollback();

			while (true) {
				Message message = connector.getWithoutAck(batchSize);
				long batchId = message.getId();
				int size = message.getEntries().size();
				if (batchId == -1 || size == 0) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else {
					printEntry(message.getEntries());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void printEntry(List<Entry> entrys) {
		for (Entry entry : entrys) {
			if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN
					|| entry.getEntryType() == EntryType.TRANSACTIONEND) {
				continue;
			}

			RowChange rowChage = null;
			try {
				rowChage = RowChange.parseFrom(entry.getStoreValue());
			} catch (Exception e) {
				throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
						e);
			}

			EventType eventType = rowChage.getEventType();
			System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
					entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
					entry.getHeader().getSchemaName(), entry.getHeader().getTableName(), eventType));

			WriteTask task = redisManager.getTaskByType(entry.getHeader().getTableName());
			if (task == null) {
				logger.error("不支持类型");
				continue;
			}
			task.setEvent(eventType);
			task.setRowChange(rowChage);
			redisManager.submit(task);
		}
	}

}
