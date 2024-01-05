package com.consumer.MQconsumer.amqp.implementation;

import com.consumer.MQconsumer.amqp.AmqpConsumer;
import com.consumer.MQconsumer.dto.MessageQueue;
import com.consumer.MQconsumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<MessageQueue> {


    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(MessageQueue message) {
        try {
            consumerService.action(message);

        }catch (Exception e){
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
