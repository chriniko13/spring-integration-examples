package com.chriniko.spring.integration.example.client.splitter;

import com.chriniko.spring.integration.example.client.domain.Programmer;
import com.chriniko.spring.integration.example.client.domain.Programmers;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Collections;
import java.util.List;

public class ProgrammersSplitter extends AbstractMessageSplitter {


    @Override
    protected Object splitMessage(Message<?> message) {

        Programmers programmers = (Programmers) message.getPayload();

        List<Programmer> programmer = programmers.getProgrammer();

        if (programmer == null || programmer.isEmpty()) {
            return MessageBuilder
                    .withPayload(Collections.<List<Message<Programmer>>>emptyList())
                    .copyHeadersIfAbsent(message.getHeaders())
                    .build();
        }

        return MessageBuilder
                .withPayload(programmer)
                .copyHeadersIfAbsent(message.getHeaders())
                .build();
    }
}
