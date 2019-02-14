package com.servant.wiki.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servant.wiki.api.HelloFeiginService;
import com.servant.wiki.common.util.JsonUtils;
import com.servant.wiki.core.baidu.aip.ValidateService;
import com.servant.wiki.core.entity.validate.ValidateResponse;
import com.servant.wiki.core.service.HelloService;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSON;

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
	
	@Autowired
	private ValidateService validateService;
	
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
	
	@ApiOperation(value="validateTest", notes="")
	@RequestMapping(value = "/validateTest", method = RequestMethod.GET)
	public void validateTest(){
		try {
			String content = "傻逼";
			ValidateResponse validateResponse = validateService.checkContent(content);
			logger.info("=========={}",JsonUtils.toJson(validateResponse));
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	@ApiOperation(value="stackTest", notes="")
	@RequestMapping(value = "/stackTest", method = RequestMethod.GET)
	public void stackTest(){
		try {
			helloService.stackTest();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	@ApiOperation(value="mybatisTest", notes="")
	@RequestMapping(value = "/mybatisTest", method = RequestMethod.GET)
	public void mybatisTest(){
		try {
			helloService.mybatisTest();
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
