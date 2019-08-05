package com.softfeeder.poc.broker.kafka;

import javax.jms.JMSException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = KafkaConfig.TOPIC, concurrency = "40")
	public Message<?> consumer(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.CORRELATION_ID) byte[] correlation, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) throws JMSException, InterruptedException {

		return MessageBuilder.withPayload(message).setHeader(KafkaHeaders.TOPIC, KafkaConfig.TOPIC_REPLAY)
				.setHeader(KafkaHeaders.CORRELATION_ID, correlation).setHeader(KafkaHeaders.MESSAGE_KEY, key).build();
	}

}
