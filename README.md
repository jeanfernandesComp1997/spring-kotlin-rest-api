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

```bash
sudo docker build -t forum-api -f Dockerfile .
```

```bash
sudo docker run -p 3000:8080 forum-api 
```

## Deploy on Heroku

```bash
heroku login
```

```bash
heroku create
```

```bash
heroku git:remote -a shielded-hollows-88487
```

```bash
$ sudo usermod -aG myuser sally
$ sudo groupadd docker
$ sudo usermod -aG docker sally
$ su - sally
```

```bash
heroku container:login
```

```bash
heroku container:push web
```

```bash
heroku container:release web
```