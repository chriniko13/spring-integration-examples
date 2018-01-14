package com.chriniko.spring.integration.example.client.example;

import com.chriniko.spring.integration.example.client.domain.Package;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwelvethExample implements Example {

    @Override
    public void run() {

        // get the necessary context in order to run the example...
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("config-integration-example-12.xml");


        // time to poll (listen) for a completed message...
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        PollableChannel packagesProcessedChannel = context.getBean("packages-processed-channel",
                PollableChannel.class);

        executorService.submit(() -> {

            Message<?> receivedMessage = packagesProcessedChannel.receive();
            System.out.println("receivedMessage == " + receivedMessage);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }

            executorService.shutdownNow();
        });


        // time to send a message...
        MessageChannel packagesChannel = context.getBean("packages-channel", MessageChannel.class);

        boolean send = packagesChannel.send(MessageBuilder.withPayload(new Package()).build());
        if (!send) {
            throw new IllegalStateException();
        }




    }
}
