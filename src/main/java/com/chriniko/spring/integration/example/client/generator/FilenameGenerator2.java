package com.chriniko.spring.integration.example.client.generator;

import org.springframework.integration.file.FileNameGenerator;
import org.springframework.messaging.Message;

public class FilenameGenerator2 implements FileNameGenerator {

    @Override
    public String generateFileName(Message<?> message) {
        String fileName = (String) message.getHeaders().get("file_name");
        return "outbound_" + fileName;
    }
}
