package com.consumer.MQconsumer.service.implementation;

import com.consumer.MQconsumer.dto.Message;
import com.consumer.MQconsumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {


    @Override
    public void action(Message message) {
        System.out.println(message.getText());
    }
}
