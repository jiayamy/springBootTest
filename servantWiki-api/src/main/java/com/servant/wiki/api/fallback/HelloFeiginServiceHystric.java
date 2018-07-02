package com.servant.wiki.api.fallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.servant.wiki.api.HelloFeiginService;

@Component
public class HelloFeiginServiceHystric implements HelloFeiginService {
	
	Logger logger = LoggerFactory.getLogger(HelloFeiginServiceHystric.class);

	@Override
	public void SayHello() {
		logger.debug("hello feigin service is down!");
	}

}
