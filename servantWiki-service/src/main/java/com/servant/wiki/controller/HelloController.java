package com.servant.wiki.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servant.wiki.service.HelloService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private HelloService helloService;
	
	@ApiOperation(value="hello", notes="")
	@RequestMapping(value = "/sayHello")
	public void hello(){
		logger.info("----------hello controller----------");
		helloService.sayHello();
	}
}
