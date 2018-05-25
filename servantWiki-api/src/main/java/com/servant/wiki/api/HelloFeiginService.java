package com.servant.wiki.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "helloFeiginService")
public interface HelloFeiginService {
	
	@RequestMapping(value = "/hello/sayHello", method = RequestMethod.GET)
	public void SayHello();
}
