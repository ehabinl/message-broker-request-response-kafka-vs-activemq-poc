package com.winfooz.producer.activemq;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ehakawati
 *
 */
@Service
public class ActiveMQProducer {

	public static final String QUEUENAME = "ehab.test.request-response";

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * 
	 * @param text
	 * @return
	 * @throws JmsException
	 * @throws JMSException
	 */
	public String producer(final String text) throws JmsException, JMSException {

		return ((TextMessage) (jmsTemplate.sendAndReceive(QUEUENAME, session -> {
			final TextMessage textMessage = session.createTextMessage(text);
			textMessage.setJMSCorrelationID(UUID.randomUUID().toString());
			return textMessage;
		}))).getText();
	}

}
