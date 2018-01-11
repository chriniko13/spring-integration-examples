package com.chriniko.spring.integration.example.client.selector;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class FilenameSelector implements MessageSelector {

    private static final String TO_PROCESS = "to-process";

    private final List<Predicate<Message<?>>> predicatesToSatisfy;
    private final Predicate<Message<?>> aggregator;

    public FilenameSelector() {
        predicatesToSatisfy = new LinkedList<>();

        predicatesToSatisfy.add(message -> message.getPayload() instanceof File);
        predicatesToSatisfy.add(message -> ((File)message.getPayload()).getName().contains(TO_PROCESS));

        aggregator = predicatesToSatisfy.stream().reduce(msg -> true, Predicate::and);
    }

    @Override
    public boolean accept(Message<?> message) {
        return aggregator.test(message);
    }
}
