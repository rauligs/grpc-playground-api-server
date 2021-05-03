# Playground gRPC API (server)
- Learning about building gRPC Services

## Build
- Run build: `./gradlew clean build`
- Build into a Native Image: `./gradlew dockerBuildNative`. 
  It creates a docker image tagged by default as `grpc-playground-api-server:latest`

## Run (Docker compose)
- Default `latest`: `docker-compose up -d`
- Override version, i.e. `1.0`: `PLAYGROUND_API_VERSION=1.0 docker-compose up -d`

## To-do next
- [X] Build Native (Graalvm)
- [X] gRPC Health Check  
- [ ] TDD approach for gRPC applications
- [ ] Proto files sync for clients 
- [ ] Contract testing

## Resources

### Micronaut
- [Graal - Micronaut Gradle Plugin](https://github.com/micronaut-projects/micronaut-gradle-plugin)
- [gRPC example in Java](https://github.com/micronaut-projects/micronaut-grpc/tree/master/examples/hello-world-java)

### gRPC
#### General
- [Basics](https://grpc.io/docs/what-is-grpc/core-concepts/)
- [Curated list of resources](https://github.com/grpc-ecosystem/awesome-grpc)

#### Clean gRPC
- [Official Style Guide](https://developers.google.com/protocol-buffers/docs/style)

#### Health Check
- [gRPC Health Checking](https://github.com/grpc/grpc/blob/master/doc/health-checking.md) to enable [grpc-health-probe](https://github.com/grpc-ecosystem/grpc-health-probe) 
- [Implementing health checks in gRPC containers (Kubernetes)](https://medium.com/@github.gkarthiks/implementing-healthchecks-in-grpc-containers-for-kubernetes-d5049989ab12)

#### Building services - strategies
- [Blog - Libraries for gRPC Services](https://www.bugsnag.com/blog/libraries-for-grpc-services)
- [Blog - How Namely builds gRPC Services](https://medium.com/namely-labs/how-we-build-grpc-services-at-namely-52a3ae9e7c35)
