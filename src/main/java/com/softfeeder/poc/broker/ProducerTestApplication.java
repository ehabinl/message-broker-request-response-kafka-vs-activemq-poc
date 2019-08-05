package com.softfeeder.poc.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * 
 * @author ehakawati
 *
 */
@SpringBootApplication
@Configuration
@EnableWebMvc
public class ProducerTestApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProducerTestApplication.class, args);
	}

}
