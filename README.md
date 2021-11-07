# Microservices with authentication

This project is based on the [tutorial](https://www.youtube.com/playlist?list=PLSVW22jAG8pDY3lXXEv1hKVIAlnJ9nDN_) given by [@SaiUpadhyayula](https://github.com/SaiUpadhyayula/springboot-microservices-project) on his YouTube Channel. My goal was understand the concepts of microservices and how to implement them using Spring projects. Along the way there were several problems I encountered, mainly regarding authentication that I was able to solve and make it work.

With the Java code and the dependencies used in each service, there is a `docker-compose.yml` file on the root of the project that lists other technologies required for this project to run.

## Product Service
### Dependencies
- Lombok
- Spring Web
- Spring Data MongoDb

#### Steps:
1. On properties file, add the MongoDB configuration:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/product-service
```

To add a secret using Vault, use the following command:
```shell
vault kv put secret/product-service/ @product-service.json
```
