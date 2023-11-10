package com.consumer.MQconsumer.service;

import com.consumer.MQconsumer.dto.Message;

public interface ConsumerService {

    void action(Message message);
}
