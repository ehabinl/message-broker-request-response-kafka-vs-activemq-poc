package com.winfooz.producer.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author ehakawati
 *
 */
@Service
public class ActiveMQConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * 
	 * @param message
	 * @throws JMSException
	 * @throws InterruptedException
	 */
	@JmsListener(destination = ActiveMQProducer.QUEUENAME, concurrency = "40")
	public void consumer(TextMessage message) throws JMSException, InterruptedException {
		jmsTemplate.send(message.getJMSReplyTo(), session -> {
			Message responseMsg = session.createTextMessage(message.getText());
			responseMsg.setJMSCorrelationID(message.getJMSCorrelationID());
			return responseMsg;
		});
	}
}
