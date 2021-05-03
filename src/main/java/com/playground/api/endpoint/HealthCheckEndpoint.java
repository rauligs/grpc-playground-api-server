package com.playground.api.endpoint;

import grpc.health.v1.HealthCheck;
import grpc.health.v1.HealthCheck.HealthCheckResponse;
import grpc.health.v1.HealthGrpc;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

import static grpc.health.v1.HealthCheck.HealthCheckResponse.ServingStatus.*;


@Singleton
public class HealthCheckEndpoint extends HealthGrpc.HealthImplBase {
    @Override
    public void check(HealthCheck.HealthCheckRequest request,
                      StreamObserver<HealthCheckResponse> responseObserver) {
        reportServingStatus(responseObserver);
    }

    @Override
    public void watch(HealthCheck.HealthCheckRequest request,
                      StreamObserver<HealthCheckResponse> responseObserver) {
        reportServingStatus(responseObserver);
    }

    private void reportServingStatus(StreamObserver<HealthCheckResponse> responseObserver) {
        responseObserver.onNext(
            HealthCheckResponse.newBuilder().setStatus(SERVING).build());
        responseObserver.onCompleted();
    }
}
