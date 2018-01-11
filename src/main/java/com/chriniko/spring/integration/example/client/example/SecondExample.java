package com.chriniko.spring.integration.example.client.example;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SecondExample implements Example {

    @Override
    public void run() {

        new ClassPathXmlApplicationContext("config-integration-example-2.xml");

        while (true) {
        }

    }
}
