package com.servant.wiki.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servant.wiki.core.service.HelloService;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author lijia
 *
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private HelloService helloService;
	
	@ApiOperation(value="hello", notes="")
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public void hello(){
		logger.info("----------hello controller----------");
		helloService.sayHello();
	}
	
	@ApiOperation(value="logTest", notes="")
	@RequestMapping(value = "/logTest", method = RequestMethod.GET)
	public void logTest(){
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			
		}
	}
	
	@ApiOperation(value="threadTest", notes="")
	@RequestMapping(value = "/threadTest", method = RequestMethod.GET)
	public void threadTest(){
		for(int i = 0; i < 5; i++){
			helloService.method();
		}
	}
}
