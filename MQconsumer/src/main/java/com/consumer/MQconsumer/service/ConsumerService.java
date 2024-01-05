package com.consumer.MQconsumer.service;

import com.consumer.MQconsumer.dto.MessageQueue;

public interface ConsumerService {

    void action(MessageQueue message);
}
