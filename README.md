## gRPC

gRPC 介绍教程

## 快速开始

导入IDEA中：

- `mvn clean package -DskipTests`

- 并将 `target/generated-sources/protobuf/grpc-java` 、`target/generated-sources/protobuf/java` 
右键选择 `Mark Directory As ---> Genarated Sources Root`

- 分别运行 `src/main/java/com/github/jaredtan95/demo/grpc/server/GrpcServer.java` 、`src/main/java/com/github/jaredtan95/demo/grpc/client/GrpcClient.java`;
