package com.playground.api;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class GrpcPlaygroundApiServerTest {

    @Inject
    private EmbeddedApplication<?> application;

    @Test
    void isRunning_shouldReturnTrue_whenApplicationStarts() {
        Assertions.assertTrue(application.isRunning());
    }

   /* @Test
    void health_shouldReturnStatusIsUp () {
        // TODO How to test it standalone without proto generated health indicator
        //  - Documentation is incomplete. It seems a custom proto health is needed
        GrpcServerHealthIndicator healthIndicator = application.getApplicationContext().getBean(GrpcServerHealthIndicator.class);
        BlockingFirstSubscriber<HealthResult> subscriber = new BlockingFirstSubscriber<>();
        healthIndicator.getResult().subscribe(subscriber);

        HealthResult healthResult = subscriber.blockingGet();
        assertEquals(HealthStatus.UP, healthResult.getStatus());
    }*/
}
