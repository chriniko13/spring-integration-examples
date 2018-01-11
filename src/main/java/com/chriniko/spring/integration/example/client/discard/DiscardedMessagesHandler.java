package com.chriniko.spring.integration.example.client.discard;

import org.springframework.messaging.Message;

public class DiscardedMessagesHandler {

    public void handle(Message<?> message) {

        String threadName = Thread.currentThread().getName();

        System.out.println("~~~~~~~~~DISCARDED MESSAGE~~~~~~~~~~");

        System.out.println("[threadName = "
                + threadName
                + "] --- Discarded Message = "
                + message);


        System.out.println();
    }
}
