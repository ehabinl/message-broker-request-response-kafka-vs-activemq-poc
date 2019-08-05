package com.winfooz.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.LongStream;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.JmsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winfooz.producer.activemq.ActiveMQProducer;
import com.winfooz.producer.kafka.KafkaProducer;

@RestController
public class Controller {

	@Autowired
	private ActiveMQProducer mqProducer;

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping("/test")
	public ResponseEntity<String> test(@RequestParam(defaultValue = "10") final Long iterations,
			@RequestParam(defaultValue = "2") final Long threads) {

		long start = System.nanoTime();

		// Active MQ POC
		LongStream.range(0, threads).parallel().forEach(threadName -> {

			final List<String> messages = new ArrayList<>();

			final String thread = "test" + threadName;

			LongStream.range(0, iterations).forEach(index -> {
				messages.add(thread);
			});

			long innerStart = System.nanoTime();

			messages.parallelStream().forEach(message -> {
				try {
					mqProducer.producer(message);
				} catch (JmsException | JMSException e) {
					e.printStackTrace();
				}
			});
			System.out.println("\t Thread Active MQ Time = " + (System.nanoTime() - innerStart));
		});

		System.out.println("\nTotal Active MQ Time\t= " + (System.nanoTime() - start) + "\n");

		start = System.nanoTime();

		// KAFKA POC
		LongStream.range(0, threads).parallel().forEach(threadName -> {

			final List<String> messages = new ArrayList<>();

			final String thread = "test" + threadName;

			LongStream.range(0, iterations).forEach(index -> {
				messages.add(thread);
			});

			long innerStart = System.nanoTime();

			messages.parallelStream().forEach(message -> {
				try {
					kafkaProducer.producer(message);
				} catch (JmsException | JMSException | InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});

			System.out.println("\t Thread Kafka Time \t= " + (System.nanoTime() - innerStart));

		});

		System.out.println("\nTotal Kafka Time = " + (System.nanoTime() - start) + "\n");

		System.out.println("\n---------------------------\n");

		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

}
