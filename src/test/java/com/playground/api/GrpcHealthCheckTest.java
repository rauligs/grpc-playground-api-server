package com.playground.api;

import grpc.health.v1.GrpcHealtchCheck;
import grpc.health.v1.GrpcHealtchCheck.HealthCheckResponse.ServingStatus;
import grpc.health.v1.HealthGrpc;
import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import io.micronaut.grpc.server.GrpcServerChannel;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class GrpcHealthCheckTest {

    @Inject
    private HealthGrpc.HealthBlockingStub grpcHealthCheckClient;

    @Test
    void healthCheck_shouldReturnExpectedServingStatus() {
        ServingStatus servingStatus =
            grpcHealthCheckClient.check(GrpcHealtchCheck.HealthCheckRequest.newBuilder().build()).getStatus();

        assertEquals(ServingStatus.SERVING, servingStatus);
    }

    @Test
    void healthWatch_shouldReturnExpectedServingStatus() {
        ServingStatus servingStatus =
            grpcHealthCheckClient.check(GrpcHealtchCheck.HealthCheckRequest.newBuilder().build()).getStatus();

        assertEquals(ServingStatus.SERVING, servingStatus);
    }
}

@Factory
class GrpcHealthCheckClient {
    @Bean
    HealthGrpc.HealthBlockingStub blockingStub(@GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel) {
        return HealthGrpc.newBlockingStub(channel);
    }
}
