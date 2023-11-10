package com.consumer.MQconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MQconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MQconsumerApplication.class, args);
	}

}
