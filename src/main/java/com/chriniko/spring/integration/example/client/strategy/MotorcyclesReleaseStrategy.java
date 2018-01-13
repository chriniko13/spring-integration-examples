package com.chriniko.spring.integration.example.client.strategy;

import com.chriniko.spring.integration.example.client.config.MotorcyclesConfig;
import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

public class MotorcyclesReleaseStrategy implements ReleaseStrategy {

    @Override
    public boolean canRelease(MessageGroup group) {
        return group.size() == MotorcyclesConfig.PACKAGE_SIZE;
    }
}
