# spring-kotlin-rest-api

Spring Rest API with Kotlin Example

## Technologies
- Kotlin
- Spring
- H2
- Flyway
- Gradle

## About

This API uses JPA, Hibernate and Flyway migrations with de memory database H2, this code support any other database.
This implementation use JWT Authentication with polices, we can use this API as a template for our API's.

## Running local

Add the follow command on VM Options

```bash
-Dspring.profiles.active=dev
```

## Running with Docker

```dockerfile
sudo docker build -t forum-api -f Dockerfile .
```

```dockerfile
sudo docker run -p 3000:8080 forum-api 
```
