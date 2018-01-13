package com.chriniko.spring.integration.example.client.example;

import com.chriniko.spring.integration.example.client.config.MotorcyclesConfig;
import com.chriniko.spring.integration.example.client.domain.Motorcycle;
import com.chriniko.spring.integration.example.client.gateway.TestRideMotorcyclesGateway;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EleventhExample implements Example {

    @Override
    public void run() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config-integration-example-11.xml");


        TestRideMotorcyclesGateway gateway = context.getBean("testRideMotorcyclesGateway", TestRideMotorcyclesGateway.class);

        final List<Motorcycle> motorcycles = new ArrayList<>();
        motorcycles.add(new Motorcycle("Ducati", "1098", BigDecimal.valueOf(25000.32D)));
        motorcycles.add(new Motorcycle("Suzuki", "GSXR-1000", BigDecimal.valueOf(17000.32D)));
        motorcycles.add(new Motorcycle("Yamaha", "R1", BigDecimal.valueOf(19340.32D)));
        motorcycles.add(new Motorcycle("Kawasaki", "ZX10R", BigDecimal.valueOf(21340.32D)));
        motorcycles.add(new Motorcycle("Honda", "CBR1000RR", BigDecimal.valueOf(22340.32D)));


        if (motorcycles.size() != MotorcyclesConfig.PACKAGE_SIZE) {
            throw new IllegalStateException();
        }

        Future<Map<Motorcycle, Map<String, String>>> result = gateway.isAvailableForTestRide(motorcycles);


        try {
            Map<Motorcycle, Map<String, String>> results = result.get();

            System.out.println(" RESULTS == " + results);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.err);
        }


    }
}
