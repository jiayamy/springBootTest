package com.servant.wiki.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servant.wiki.common.config.Global;
import com.servant.wiki.common.model.stack.FixCapacityStack;
import com.servant.wiki.common.model.stack.LinkedStack;
import com.servant.wiki.common.util.JsonUtils;
import com.servant.wiki.core.config.SpringConfig;
import com.servant.wiki.core.config.redis.JedisTemplate;
import com.servant.wiki.core.config.redis.JedisUtils;
import com.servant.wiki.core.dao.HelloDao;
import com.servant.wiki.core.entity.Demo;
import com.servant.wiki.core.entity.HqDemo;
import com.servant.wiki.core.repository.HelloRepository;

/**
 * 
 * @author lijia
 *
 */
@Service
public class HelloService {

	Logger logger = LoggerFactory.getLogger(HelloService.class);

	@Autowired
	private HelloRepository helloRepository;
	
	@Autowired
	private HelloDao helloDao;

	@PersistenceContext
	EntityManager em;

	@Autowired
	SpringConfig springConfig;

	JedisTemplate jedis = JedisUtils.getJedisTemplate();

	@SuppressWarnings("unchecked")
	@Transactional(value = "transactionManager")
	public void sayHello() {
		logger.info("----------hello service----" + Global.getConfig("env") + "-----");
		List<Demo> demos = helloRepository.findListByContent("test");
		for (Demo demo : demos) {
			logger.info("=======demo content: {}", demo.getContent());
		}
		// List<HqDemo> hqDemos = hqDao.getDate();

		Query q = em.createNamedQuery("HqDemo.getDataById");
		q.setParameter(1, 2);
		List<HqDemo> hqDemos = q.getResultList();
		for (HqDemo demo : hqDemos) {
			logger.info("=======Hqdemo content: {}", JsonUtils.toJson(demo));
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(value = "mybatisTxManager")
	public void mybatisTest() {
		Demo demo = new Demo();
		demo.setContent("insertTest");
		helloDao.insert(demo);
		Map param = new HashMap<>();
		param.put("content", "insertTest");
		List<Demo> demos = helloDao.selectParam(param);
		for (Demo d : demos) {
			logger.info("=======demo content: {}", d.getContent());
			helloDao.deleteEnrollById(d.getId());
		}
	}

	@Async
	public void method() {
		logger.info("========method " + Thread.currentThread().getName() + " begin==========");
		try {
			String str = this.redisGetTest(Thread.currentThread().getName());
			logger.info("=========" + Thread.currentThread().getName() + "====" + str + "======");
		} catch (Exception e) {
		}
		logger.info("========method " + Thread.currentThread().getName() + " end==========");
	}

	public void redisTest() {
		jedis.set("first", "test");
		String str = jedis.get("first");
		logger.info("-----------" + str);
	}

	public void jpaSepcTest() {
		Demo demo = new Demo();
		demo.setId(1);
	}

	/**
	 * redis查询策略
	 * 
	 * @param name
	 * @return
	 */
	public String redisGetTest(String name) {
		String str = jedis.get("first");
		if (str == null || str.equals("NULL") || str.equals("&&")) {
			boolean flag = jedis.setnx("first", "&&");
			if (flag) {
				logger.info("======" + name + " query======");
				Demo demo = helloRepository.findOne(1);
				if (demo != null) {
					jedis.set("first", demo.getContent());
					return demo.getContent();
				} else {
					jedis.set("first", "NULL");
					return "NULL";
				}
			} else {
				if ("NULL".equals(str)) {
					return str;
				}
				try {
					Thread.sleep(100);
					return this.redisGetTest(name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return str;
	}

	public void mongoTest() {
		Demo demo = new Demo();
		demo.setContent("test111");
		demo.setId(33);
	}

	public void stackTest() {
		LinkedStack linkedStack = new LinkedStack();
		FixCapacityStack fixCapacityStack = new FixCapacityStack(20);
		for (int i = 0; i < 20; i++) {
			linkedStack.push(i);
			fixCapacityStack.push(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(linkedStack.pop());
			System.out.println(fixCapacityStack.pop());
		}
	}
}
