package com.consumer.MQconsumer.amqp;

public interface AmqpConsumer<T> {

    public void consumer(T t);
}
