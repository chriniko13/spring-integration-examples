package com.chriniko.spring.integration.example.client.activator;

import com.chriniko.spring.integration.example.client.domain.Package;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PackageActivator {

    public Message<Package> handle(Message<Package> message) {

        System.out.println("PackageActivator#handle, payload = " + message);

        message.getPayload().setType("____TYPE____");

        return MessageBuilder.fromMessage(message).build();
    }
}
