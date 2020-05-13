package com.example.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
		try {
			KafkaConsumerDemo.runConsumer();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
