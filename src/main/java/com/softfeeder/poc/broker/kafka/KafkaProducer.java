package com.softfeeder.poc.broker.kafka;

import java.util.concurrent.ExecutionException;

import javax.jms.JMSException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ehakawati
 *
 */
@Service
public class KafkaProducer {

	@Autowired
	private ReplyingKafkaTemplate<String, String, String> kafkaTemplate;

	/**
	 * 
	 * @param text
	 * @return
	 * @throws JmsException
	 * @throws JMSException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public String producer(final String text)
			throws JmsException, JMSException, InterruptedException, ExecutionException {

		ProducerRecord<String, String> record = new ProducerRecord<String, String>(KafkaConfig.TOPIC, "Test", text);

		ConsumerRecord<String, String> response = kafkaTemplate.sendAndReceive(record).get();

		return response.value();
	}

}
