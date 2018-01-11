package com.chriniko.spring.integration.example.client.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstExample implements Example {


    @Override
    public void run() {

        new ClassPathXmlApplicationContext("config-integration-example-1.xml");

        while (true) {
        }

    }

}
