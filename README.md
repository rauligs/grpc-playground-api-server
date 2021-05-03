# Playground gRPC API (server)
- Learning about building gRPC Services

## Build
- Run build: `./gradlew clean build`
- Build into a Native Image: `./gradlew dockerBuildNative`. 
  It creates a docker image tagged by default as `grpc-playground-api-server:latest`


## To-do next
- [X] Build Native (Graalvm)
- [ ] gRPC Health Check  
- [ ] TDD approach for gRPC applications
- [ ] Proto files sync for clients 
- [ ] Contract testing

## Resources

### Micronaut
- [Graal - Micronaut Gradle Plugin](https://github.com/micronaut-projects/micronaut-gradle-plugin)
- [gRPC example in Java](https://github.com/micronaut-projects/micronaut-grpc/tree/master/examples/hello-world-java)

### General gRPC
- [Basics](https://grpc.io/docs/what-is-grpc/core-concepts/)
- [Curated list of resources](https://github.com/grpc-ecosystem/awesome-grpc)
- [gRPC Health Checking](https://github.com/grpc/grpc/blob/master/doc/health-checking.md)  
- [Implementing health checks in gRPC containers (Kubernetes)](https://medium.com/@github.gkarthiks/implementing-healthchecks-in-grpc-containers-for-kubernetes-d5049989ab12)
- [Blog - Libraries for gRPC Services](https://www.bugsnag.com/blog/libraries-for-grpc-services)
- [Blog - How Namely builds gRPC Services](https://medium.com/namely-labs/how-we-build-grpc-services-at-namely-52a3ae9e7c35)
