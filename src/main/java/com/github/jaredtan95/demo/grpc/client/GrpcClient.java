package com.github.jaredtan95.demo.grpc.client;

import com.github.jaredtan95.demo.grpc.HelloRequest;
import com.github.jaredtan95.demo.grpc.HelloResponse;
import com.github.jaredtan95.demo.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                                                      .usePlaintext()
                                                      .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
            = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                                                             .setFirstName("test")
                                                             .setLastName("gRPC")
                                                             .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}
