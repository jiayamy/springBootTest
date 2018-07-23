package com.servant.wiki.worker.task.redis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import com.servant.wiki.worker.config.redis.JedisTemplate;
import com.servant.wiki.worker.config.redis.JedisUtils;
import com.servant.wiki.worker.policy.redis.Policy;
import com.servant.wiki.worker.result.BaseResult;
import com.servant.wiki.worker.worker.redis.RedisWorker;

@Component
public abstract class WriteTask extends RedisWorker {

	private static final long serialVersionUID = 1L;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	static JedisTemplate jedis = JedisUtils.getJedisMessage();

	private String type;

	private EventType event;

	private RowChange rowChange;

	public void excuteTask(Policy policy, WriteTask task, BaseResult result) {
		for (RowData rowData : rowChange.getRowDatasList()) {
			if (event == EventType.DELETE) {
				redisDelete(rowData.getBeforeColumnsList(), policy);
				printColumn(rowData.getBeforeColumnsList());
			} else if (event == EventType.INSERT) {
				redisInsert(rowData.getAfterColumnsList(), policy);
				printColumn(rowData.getAfterColumnsList());
			} else {
				System.out.println("-------> before");
				printColumn(rowData.getBeforeColumnsList());
				System.out.println("-------> after");
				redisUpdate(rowData.getAfterColumnsList(), policy);
				printColumn(rowData.getAfterColumnsList());
			}
		}
	}

	private static void printColumn(List<Column> columns) {
		for (Column column : columns) {
			System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
		}
	}

	private static void redisDelete(List<Column> columns, Policy policy) {
		JSONObject json = new JSONObject();
		for (Column column : columns) {
			json.put(column.getName(), column.getValue());
		}
		if (columns.size() > 0) {
			jedis.del(policy.getRedisKey() + columns.get(0).getValue());
		}
	}

	private static void redisInsert(List<Column> columns, Policy policy) {
		JSONObject json = new JSONObject();
		for (Column column : columns) {
			json.put(column.getName(), column.getValue());
		}
		if (columns.size() > 0) {
			jedis.set(policy.getRedisKey() + columns.get(0).getValue(), json.toJSONString(), policy.getTimeOut());
		}
	}

	private static void redisUpdate(List<Column> columns, Policy policy) {
		JSONObject json = new JSONObject();
		for (Column column : columns) {
			json.put(column.getName(), column.getValue());
		}
		if (columns.size() > 0) {
			jedis.set(policy.getRedisKey() + columns.get(0).getValue(), json.toJSONString(), policy.getTimeOut());
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EventType getEvent() {
		return event;
	}

	public void setEvent(EventType event) {
		this.event = event;
	}

	public RowChange getRowChange() {
		return rowChange;
	}

	public void setRowChange(RowChange rowChange) {
		this.rowChange = rowChange;
	}

}
