package com.consumer.MQconsumer.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class RabbitConfiguration {

    @Autowired
    private ConnectionFactory connectionFactory;


    @Bean
    SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jackson2JsonMessageConverter());
        return factory;
    }

    @Bean
    RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        final ObjectMapper mapper = Jackson2ObjectMapperBuilder
                .json()
                .modules(new JavaTimeModule())
                .dateFormat(new StdDateFormat())
                .build();
        return new Jackson2JsonMessageConverter(mapper);
    }


    /*Inicializar uma conversão de Json para objeto automaticamente*/
//    @Bean
//    public MessageConverter jsonConvert(){
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory factory(ConnectionFactory connectionFactory,
//                                                        SimpleRabbitListenerContainerFactoryConfigurer configurer){
//
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        factory.setMessageConverter(jsonConvert());
//        return factory;
//    }
}
