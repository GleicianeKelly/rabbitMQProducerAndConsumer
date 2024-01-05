package com.consumer.MQconsumer.service;

import com.consumer.MQconsumer.amqp.AmqpRePublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepublishServiceImpl implements RepublishService{

    @Autowired
    private AmqpRePublish rePublish;

    @Override
    public void repost() {
        rePublish.rePublish();
    }
}
