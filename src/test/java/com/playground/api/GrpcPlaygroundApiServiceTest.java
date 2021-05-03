package com.playground.api;

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
class GrpcPlaygroundApiServiceTest {

    @Inject
    private GreetingServerServiceGrpc.GreetingServerServiceBlockingStub messageServiceClient;

    @Test
    void messageService_shouldReturnExpectedResponse_forAGivenName() {
        String message = messageServiceClient
            .send(GreetingRequest.newBuilder().setName("Peter").build())
            .getMessage();

        assertEquals("Peter, hi! you have just made a gRPC call", message);
    }
}

@Factory
class GrpcPlaygroundApiServiceClient {
    @Bean
    GreetingServerServiceGrpc.GreetingServerServiceBlockingStub blockingStub(
        @GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel) {
        return GreetingServerServiceGrpc.newBlockingStub(channel);
    }
}
