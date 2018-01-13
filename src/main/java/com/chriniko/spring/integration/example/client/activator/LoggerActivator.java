package com.chriniko.spring.integration.example.client.activator;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class LoggerActivator implements MessageHandler {


    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println();
        System.out.println("@@@@@ MESSAGE RECEIVED @@@@@ ----> " + message);
        System.out.println("\n");
    }
}
