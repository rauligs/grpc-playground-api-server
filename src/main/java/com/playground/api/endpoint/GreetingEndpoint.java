package com.playground.api.endpoint;

import com.playground.api.GreetingReply;
import com.playground.api.GreetingRequest;
import com.playground.api.GreetingServerServiceGrpc;
import io.grpc.stub.StreamObserver;

import javax.inject.Singleton;

@Singleton
public class GreetingEndpoint extends GreetingServerServiceGrpc.GreetingServerServiceImplBase {

    @Override
    public void send(GreetingRequest request, StreamObserver<GreetingReply> responseObserver) {
        GreetingReply reply = GreetingReply.newBuilder().setMessage(request.getName() + ", hi! you have just made a gRPC call").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
