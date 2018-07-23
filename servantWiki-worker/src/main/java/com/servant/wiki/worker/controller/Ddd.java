package com.servant.wiki.worker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servant.wiki.worker.consume.DemoConsume;

@RestController
@RequestMapping(value = "/demo")
public class Ddd {

	@Autowired
	DemoConsume demoConsume;
	
	@GetMapping(value = "/demo")
	public void demo(){
		
	}
}
