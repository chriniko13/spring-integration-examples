package com.chriniko.spring.integration.example.client.transformer;

import com.chriniko.spring.integration.example.client.domain.Motorcycle;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotorcyclesTransformer {


    public Message<Map<Motorcycle, Map<String, String>>> transform(@Headers Map<String, Object> headers,
                                                                   @Header("isSystemEnabled") String isSystemEnabled,
                                                                   Message<List<Motorcycle>> message) {

        final Map<Motorcycle, Map<String, String>> results = new HashMap<>();

        for (Motorcycle motorcycle : message.getPayload()) {

            Boolean availableForTestDrive = motorcycle.getAvailableForTestDrive();


            Map<String, String> options = new HashMap<>();
            options.put("availableForTestDriver", availableForTestDrive.toString());
            options.put("isSystemEnabled", isSystemEnabled);

            results.put(motorcycle, options);

        }

        return MessageBuilder.withPayload(results).copyHeadersIfAbsent(headers).build();
    }

}
