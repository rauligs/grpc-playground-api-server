package com.playground.api;

import io.micronaut.grpc.server.health.GrpcServerHealthIndicator;
import io.micronaut.health.HealthStatus;
import io.micronaut.management.health.indicator.HealthResult;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.reactivex.internal.subscribers.BlockingFirstSubscriber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class GrpcPlaygroundApiServerTest {

    @Inject
    private EmbeddedApplication<?> application;

    @Test
    void isRunning_shouldReturnTrue_whenApplicationStarts() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void health_shouldReturnStatusIsUp () {
        GrpcServerHealthIndicator healthIndicator = application.getApplicationContext().getBean(GrpcServerHealthIndicator.class);
        BlockingFirstSubscriber<HealthResult> subscriber = new BlockingFirstSubscriber<>();
        healthIndicator.getResult().subscribe(subscriber);

        HealthResult healthResult = subscriber.blockingGet();
        assertEquals(HealthStatus.UP, healthResult.getStatus());
    }
}
