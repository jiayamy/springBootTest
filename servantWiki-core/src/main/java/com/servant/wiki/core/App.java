package com.servant.wiki.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.servant.wiki.common.config.constants.Constants;
import com.servant.wiki.common.util.JsonUtils;
import com.servant.wiki.core.config.DefaultProfileUtil;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.servant.wiki.core")
@EnableJpaRepositories("com.servant.wiki.core.dao")
public class App {
	
	static final Logger logger = LoggerFactory.getLogger(App.class);
	
	private final Environment env;

    public App(Environment env) {
        this.env = env;
    }

	
	@PostConstruct
    public void init() {
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(Constants.Env.DEVELOPMENT) && activeProfiles.contains(Constants.Env.PRODUCTION)) {
            logger.error("You have misconfigured your application! It should not run " +
                "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(Constants.Env.DEVELOPMENT) && activeProfiles.contains(Constants.Env.TEST)) {
            logger.error("You have misconfigured your application! It should not " +
                "run with both the 'dev' and 'test' profiles at the same time.");
        }
    }
	
	public static void main(String[] args) throws UnknownHostException{
		SpringApplication app = new SpringApplication(App.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        logger.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" +
                "External: \t{}://{}:{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            env.getActiveProfiles());
		
	}
	
}
