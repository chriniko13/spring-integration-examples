package com.chriniko.spring.integration.example.client.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class ThirdExample implements Example {

    @Override
    public void run() {

        ApplicationContext context = new ClassPathXmlApplicationContext("config-integration-example-3.xml");

        MessageChannel messageChannel = context.getBean("messageChannel", MessageChannel.class);

        messageChannel.send(MessageBuilder.withPayload("one").build());
        System.out.println("first message sent...");

        messageChannel.send(MessageBuilder.withPayload("two").build());
        System.out.println("second message sent...");

        messageChannel.send(MessageBuilder.withPayload("three").build());
        System.out.println("third message sent...");

    }
}
