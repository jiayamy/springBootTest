package com.servant.wiki;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableSwagger2
public class App {
	
	Logger logger = LoggerFactory.getLogger(App.class);
	
	@PostConstruct
    public void init() {
        //初始化可执行代码
		logger.info("---------init--------");
    }
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
}
