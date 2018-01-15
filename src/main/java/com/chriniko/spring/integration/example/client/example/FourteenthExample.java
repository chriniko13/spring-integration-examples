package com.chriniko.spring.integration.example.client.example;

import com.chriniko.spring.integration.example.client.domain.Package;
import com.chriniko.spring.integration.example.client.gateway.PackagesGateway;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FourteenthExample implements Example {

    @Override
    public void run() {

        // get the necessary context in order to run the example...
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("config-integration-example-14.xml");


        // run the example...
        PackagesGateway packagesGateway = context.getBean(PackagesGateway.class);

        Future<Package> result = packagesGateway.process(new Package("some-type"));


        try {
            Package aPackage = result.get();
            System.out.println("result == " + aPackage);
        } catch (InterruptedException e) {

            e.printStackTrace(System.err);

        } catch (ExecutionException e) {

            Throwable actualCause = e.getCause();

            System.out.println("error occurred = " + actualCause.getMessage());
        }

    }
}
