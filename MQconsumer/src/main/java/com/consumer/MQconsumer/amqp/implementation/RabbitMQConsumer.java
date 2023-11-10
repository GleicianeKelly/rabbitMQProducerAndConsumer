package com.consumer.MQconsumer.amqp.implementation;

import com.consumer.MQconsumer.amqp.AmqpConsumer;
import com.consumer.MQconsumer.dto.Message;
import com.consumer.MQconsumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {


    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(Message message) {
        try {
            consumerService.action(message);

        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
