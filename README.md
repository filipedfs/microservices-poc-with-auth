# Microservices with authentication

This project is based on the [tutorial](https://www.youtube.com/playlist?list=PLSVW22jAG8pDY3lXXEv1hKVIAlnJ9nDN_) given by [@SaiUpadhyayula](https://github.com/SaiUpadhyayula/springboot-microservices-project) on his YouTube Channel. My goal was understand the concepts of microservices and how to implement them using Spring projects. Along the way there were several problems I encountered, mainly regarding authentication that I was able to solve and make it work.

With the Java code and the dependencies used in each service, there is a `docker-compose.yml` file on the root of the project that lists other technologies required for this project to run.

---

## Configuration Service
### Dependencies
- Spring Boot Starter Actuator
- Spring Cloud Config Server

---

## Discovery Server
### Dependencies
- spring-cloud-starter-netflix-eureka-server

---

## Api Gateway
### Dependencies
- spring-cloud-starter-gateway
- spring-cloud-starter-netflix-eureka-client
- spring-boot-starter-oauth2-client
- spring-security-oauth2-resource-server
- spring-boot-starter-security

---

*TODO: the services share a lot of dependencies. They could be merged in a single pom configuration file.*

---

## Inventory Service
### Dependencies
- logstash-logback-encoder
- lombok
- mysql-connector-java
- spring-boot-starter-data-jpa
- spring-boot-starter-oauth2-resource-server
- spring-boot-starter-security
- spring-boot-starter-test
- spring-boot-starter-web
- spring-cloud-config-client
- spring-cloud-sleuth-zipkin
- spring-cloud-starter-bootstrap
- spring-cloud-starter-bus-amqp
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-sleuth
- spring-cloud-starter-vault-config
- spring-security-oauth2-jose
- spring-security-test

---

## Notification Service
### Dependencies
- logstash-logback-encoder
- lombok
- spring-boot-starter-test
- spring-cloud-sleuth-zipkin
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-sleuth
- spring-cloud-stream
- spring-cloud-stream
- spring-cloud-stream-binder-rabbit

---

## Order Service
### Dependencies
- logstash-logback-encoder
- lombok
- mysql-connector-java
- spring-boot-starter-actuator
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-test
- spring-boot-starter-web
- spring-cloud-config-client
- spring-cloud-sleuth-zipkin
- spring-cloud-starter-bootstrap
- spring-cloud-starter-bus-amqp
- spring-cloud-starter-circuitbreaker-reactor-resilience4j
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-openfeign
- spring-cloud-starter-sleuth
- spring-cloud-starter-vault-config
- spring-cloud-stream-binder-rabbit
- spring-security-oauth2-jose
- spring-security-oauth2-resource-server

---

## Product Service
### Dependencies
- spring-boot-starter-web
- spring-boot-starter-data-mongodb
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-config-client
- spring-cloud-starter-bootstrap
- spring-boot-starter-actuator
- spring-cloud-starter-vault-config
- spring-cloud-starter-bus-amqp
- spring-security-oauth2-resource-server
- spring-security-oauth2-jose
- spring-boot-starter-security
- logstash-logback-encoder
- spring-cloud-starter-sleuth
- spring-cloud-sleuth-zipkin
- lombok
- spring-boot-starter-test

---



#### Steps: (TODO: add steps)
1. On properties file, add the MongoDB configuration:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/product-service
```

To add the secrets using Vault, run the script on root folder (`vault_secrets.sh`):
```shell
sh vaul_secrets.sh
```
