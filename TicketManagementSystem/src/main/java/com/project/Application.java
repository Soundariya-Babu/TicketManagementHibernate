package com.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.project")
public class Application {
	private static Logger logger = LogManager.getLogger(Application.class);

	public static void main(String[] args) {

		logger.info("Initializing Spring boot");
		SpringApplication.run(Application.class, args);
	}

}
