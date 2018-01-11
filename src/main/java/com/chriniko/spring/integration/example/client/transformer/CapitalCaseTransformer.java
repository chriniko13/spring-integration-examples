package com.chriniko.spring.integration.example.client.transformer;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CapitalCaseTransformer {

    public Message<?> transform(@Headers Map<String, Object> headers, Message<?> message) {

        String payload = (String) message.getPayload();

        String capitalizedPayload = Arrays
                .stream(payload.split("\n"))
                .map(String::toUpperCase)
                .collect(Collectors.joining("\n"));

        return MessageBuilder
                .withPayload(capitalizedPayload)
                .copyHeadersIfAbsent(headers)
                .build();
    }
}
