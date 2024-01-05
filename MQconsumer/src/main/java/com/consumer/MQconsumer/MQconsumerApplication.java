package com.consumer.MQconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
//@ComponentScan("com.consumer.MQconsumer")
public class MQconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MQconsumerApplication.class, args);
	}

}
