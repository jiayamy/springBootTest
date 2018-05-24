package com.servant.wiki.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.servant.wiki.common.config.Global;

@Service
public class HelloService {

	Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	public void sayHello(){
		logger.info("----------hello service----"+Global.getConfig("env")+" 1-----");
	}
}
