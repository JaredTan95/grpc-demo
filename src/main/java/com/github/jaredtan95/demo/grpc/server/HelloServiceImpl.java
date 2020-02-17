package com.github.jaredtan95.demo.grpc.server;

import com.github.jaredtan95.demo.grpc.HelloRequest;
import com.github.jaredtan95.demo.grpc.HelloResponse;
import com.github.jaredtan95.demo.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
        HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        String greeting = new StringBuilder().append("Hello, ")
                                             .append(request.getFirstName())
                                             .append(" ")
                                             .append(request.getLastName())
                                             .toString();

        HelloResponse response = HelloResponse.newBuilder()
                                              .setGreeting(greeting)
                                              .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
