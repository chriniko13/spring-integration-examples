package com.chriniko.spring.integration.example.client.activator;

import com.chriniko.spring.integration.example.client.domain.Package;
import org.springframework.messaging.Message;

public class PackageTypeEnricher {


    public String enrich(Message<Package> message) {

        System.out.println("PackageTypeEnricher#enrich, message == " + message);

        return "SOME_TYPE";
    }
}
