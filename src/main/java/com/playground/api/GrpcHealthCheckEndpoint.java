package com.playground.api;

import grpc.health.v1.GrpcHealtchCheck;
import grpc.health.v1.HealthGrpc;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

import static grpc.health.v1.GrpcHealtchCheck.HealthCheckResponse.ServingStatus.SERVING;
import static grpc.health.v1.GrpcHealtchCheck.HealthCheckResponse.newBuilder;

@Singleton
public class GrpcHealthCheckEndpoint extends HealthGrpc.HealthImplBase {
    @Override
    public void check(GrpcHealtchCheck.HealthCheckRequest request,
                      StreamObserver<GrpcHealtchCheck.HealthCheckResponse> responseObserver) {
        reportServingStatus(responseObserver);
    }

    @Override
    public void watch(GrpcHealtchCheck.HealthCheckRequest request,
                      StreamObserver<GrpcHealtchCheck.HealthCheckResponse> responseObserver) {
        reportServingStatus(responseObserver);
    }

    private void reportServingStatus(StreamObserver<GrpcHealtchCheck.HealthCheckResponse> responseObserver) {
        responseObserver.onNext(newBuilder().setStatus(SERVING).build());
        responseObserver.onCompleted();
    }
}
