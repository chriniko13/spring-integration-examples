package com.chriniko.spring.integration.example.client.generator;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

import java.io.File;

public class FilenameGenerator3 implements FileNameGenerator {

    @Override
    public String generateFileName(Message<?> message) {

        File file = (File) message.getPayload();
        return "outbound_" + file.getName();
    }
}
