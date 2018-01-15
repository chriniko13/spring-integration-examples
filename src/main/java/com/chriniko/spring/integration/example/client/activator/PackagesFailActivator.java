package com.chriniko.spring.integration.example.client.activator;

import com.chriniko.spring.integration.example.client.domain.Package;
import org.springframework.messaging.Message;

public class PackagesFailActivator {

    public Message<Package> handle(Message<Package> message) {

        throw new IllegalStateException("ooops, an error occurred");

    }

}
