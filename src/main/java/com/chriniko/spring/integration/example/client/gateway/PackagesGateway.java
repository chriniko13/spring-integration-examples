package com.chriniko.spring.integration.example.client.gateway;

import com.chriniko.spring.integration.example.client.domain.Package;

import java.util.concurrent.Future;

public interface PackagesGateway {

    Future<Package> process(Package aPackage);

}
