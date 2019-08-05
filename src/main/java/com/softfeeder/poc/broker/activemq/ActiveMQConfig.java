package com.softfeeder.poc.broker.activemq;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.util.ErrorHandler;

/**
 * 
 * @author ehakawati
 *
 */
@Configuration
@EnableJms
public class ActiveMQConfig {

	/**
	 * 
	 * @param configurer
	 * @param connectionFactory
	 * @param errorHandler
	 * @return
	 */
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
			DefaultJmsListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory,
			ErrorHandler errorHandler) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setConcurrency("3-10");
		factory.setErrorHandler(errorHandler);
		return factory;
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public ErrorHandler JmsErrorHandler() {
		return throwable -> {
			System.err.println(throwable.getCause().getMessage());
		};
	}
}
