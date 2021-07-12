package com.example.springbootkafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springbootkafkaproducer.service.ProducerService;

@SpringBootApplication
public class SpringBootKafkaProducerApplication implements ApplicationRunner {

	@Autowired
	private ProducerService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Kafka log send starting...");
		for (int i = 0; i < 10; i++) {
			service.sendMessage(String.format("[%d] -- Hello World", i));
		}
		System.out.println("Kafka log sent...");
	}
}
