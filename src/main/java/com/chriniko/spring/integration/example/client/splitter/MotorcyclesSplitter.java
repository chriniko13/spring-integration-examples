package com.chriniko.spring.integration.example.client.splitter;

import com.chriniko.spring.integration.example.client.domain.Motorcycle;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MotorcyclesSplitter extends AbstractMessageSplitter {

    @SuppressWarnings("unchecked")
    @Override
    protected Object splitMessage(Message<?> message) {

        List<Motorcycle> motorcycles = (List<Motorcycle>) message.getPayload();

        if (motorcycles == null || motorcycles.isEmpty()) {

            return MessageBuilder
                    .withPayload(Collections.<List<Message<Motorcycle>>>emptyList())
                    .copyHeadersIfAbsent(message.getHeaders())
                    .build();
        }

        return motorcycles
                .stream()
                .map(motorcycle -> createMessage(message, motorcycle))
                .collect(Collectors.toList());

    }

    private Message<Motorcycle> createMessage(Message<?> message, Motorcycle motorcycle) {
        return MessageBuilder.withPayload(motorcycle).copyHeadersIfAbsent(message.getHeaders()).build();
    }
}
