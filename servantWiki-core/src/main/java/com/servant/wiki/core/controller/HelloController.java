package com.servant.wiki.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servant.wiki.api.HelloFeiginService;
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
	
	@Autowired
	private HelloFeiginService helloFeiginService;
	
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
	
	@ApiOperation(value="redisTest", notes="")
	@RequestMapping(value = "/redisTest", method = RequestMethod.GET)
	public void redisTest(){
		helloService.redisTest();
	}
	
	@ApiOperation(value="redisGetTest", notes="")
	@RequestMapping(value = "/redisGetTest", method = RequestMethod.GET)
	public void redisGetTest(){
		helloService.redisGetTest(null);
	}
	
	@ApiOperation(value="feiginTest", notes="")
	@RequestMapping(value = "/feiginTest", method = RequestMethod.GET)
	public void feiginTest(){
		helloFeiginService.SayHello();
	}
	
	@ApiOperation(value="jpaSepcTest", notes="")
	@RequestMapping(value = "/jpaSepcTest", method = RequestMethod.GET)
	public void jpaSepcTest(){
		
	}
	
	@ApiOperation(value="exceptionTest", notes="")
	@RequestMapping(value = "/exceptionTest", method = RequestMethod.GET)
	public void exceptionTest(){
		try {
			int a = 10/0;
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
		
		throw new RuntimeException("test");
	}
	
	@ApiOperation(value="mongoTest", notes="")
	@RequestMapping(value = "/mongoTest", method = RequestMethod.GET)
	public void mongoTest(){
		try {
			helloService.mongoTest();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
