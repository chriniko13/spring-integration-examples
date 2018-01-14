package com.chriniko.spring.integration.example.client.example;

import com.chriniko.spring.integration.example.client.domain.Package;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

public class ThirteenthExample implements Example {

    @Override
    public void run() {
        // get the necessary context in order to run the example...
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("config-integration-example-13.xml");

        // and then send a message to pub-sub channel...
        PublishSubscribeChannel packagesChannel = context.getBean("packages-channel", PublishSubscribeChannel.class);
        packagesChannel.send(MessageBuilder.withPayload(new Package("some-type")).build());


        // and then wait for the response message from rendezvous channel...
        PollableChannel packagesResultChannel = context.getBean("packages-result-channel", PollableChannel.class);
        Message<?> result = packagesResultChannel.receive();
        System.out.println("result message == " + result);
    }
}
