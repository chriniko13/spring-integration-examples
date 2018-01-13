package com.chriniko.spring.integration.example.client.gateway;

import com.chriniko.spring.integration.example.client.domain.Motorcycle;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public interface TestRideMotorcyclesGateway {


    Future<Map<Motorcycle, Map<String, String>>> isAvailableForTestRide(List<Motorcycle> motorycycles);

}
