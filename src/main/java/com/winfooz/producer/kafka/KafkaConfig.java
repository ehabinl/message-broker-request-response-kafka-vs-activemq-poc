
package com.winfooz.producer.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

@Configuration
@EnableKafka
public class KafkaConfig {

	public static final String TOPIC = "ehab.test.request-response";

	public static final String TOPIC_REPLAY;

	static {
		TOPIC_REPLAY = "ehab.test.request-response-reply-" + System.currentTimeMillis();
	}

	/**
	 * 
	 * @param containerFactory
	 * @return
	 */
	@Bean
	public ConcurrentMessageListenerContainer<Long, String> repliesContainer(
			ConcurrentKafkaListenerContainerFactory<Long, String> containerFactory) {

		ConcurrentMessageListenerContainer<Long, String> repliesContainer = containerFactory.createContainer("replies");
		repliesContainer.getContainerProperties().setGroupId("group-id");
		repliesContainer.setAutoStartup(false);

		return repliesContainer;
	}

	/**
	 * 
	 * @param pf
	 * @param replyContainer
	 * @return
	 */
	@Bean
	public ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate(
			ProducerFactory<String, String> producerFactory,
			KafkaMessageListenerContainer<String, String> replyContainer) {

		return new ReplyingKafkaTemplate<>(producerFactory, replyContainer);
	}

	/**
	 * Must be KafkaTemplate<Object, Object>
	 * 
	 * @param producerFactory
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Bean
	public KafkaTemplate<Object, Object> kafkaTemplate(ProducerFactory producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}

	/**
	 * 
	 * @param cf
	 * @return
	 */
	@Bean
	public KafkaMessageListenerContainer<String, String> replyContainer(
			ConsumerFactory<String, String> consumerFactory) {
		ContainerProperties containerProperties = new ContainerProperties(TOPIC_REPLAY);
		return new KafkaMessageListenerContainer<>(consumerFactory, containerProperties);
	}

//	@Bean
//	public NewTopic kRequests() {
//		return new NewTopic("kRequests", 10, (short) 2);
//	}

//	
//	@Bean
//	public NewTopic kReplies() {
//		return new NewTopic(TOPIC_REPLAY, 10, (short) 2);
//	}

}
