package com.chriniko.spring.integration.example.client.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FourteenthExample implements Example {

    @Override
    public void run() {

        // get the necessary context in order to run the example...
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("config-integration-example-14.xml");


    }
}
