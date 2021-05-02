package com.playground.api;

import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class GrpcPlaygroundApiEndpoint extends GrpcPlaygroundApiServerServiceGrpc.GrpcPlaygroundApiServerServiceImplBase {

    @Override
    public void send(GrpcPlaygroundApiServerRequest request, StreamObserver<GrpcPlaygroundApiServerReply> responseObserver) {
        GrpcPlaygroundApiServerReply reply = GrpcPlaygroundApiServerReply.newBuilder().setMessage(request.getName() + ", you have just made a gRPC call").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
