package com.chriniko.spring.integration.example.client.activator;

import com.chriniko.spring.integration.example.client.domain.Package;

public class PackageActivator2 {

    public void handle(Package aPackage) {
        System.out.println("PackageActivator2#handle, payload = " + aPackage);
    }

    public void dummy() {
        System.out.println("dummy method!");
    }
}
