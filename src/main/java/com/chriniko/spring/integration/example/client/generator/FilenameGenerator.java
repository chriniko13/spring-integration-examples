package com.chriniko.spring.integration.example.client.generator;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

public class FilenameGenerator implements FileNameGenerator {

    @Override
    public String generateFileName(Message<?> message) {

        String payload = (String) message.getPayload();

        return  payload + ".txt";
    }
}
