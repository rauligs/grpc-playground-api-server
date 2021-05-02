package com.playground.api;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

@MicronautTest
class GrpcPlaygroundApiServerTest {

    @Inject
    private EmbeddedApplication<?> application;

    @Test
    void isRunning_shouldReturnTrue_whenApplicationStarts() {
        Assertions.assertTrue(application.isRunning());
    }
}
