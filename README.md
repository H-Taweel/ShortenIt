# ShortenIt.app

Project for URL Shortener service.

## Local setup

Please install the following:

* Maven
* Java 17+
* Curl
* Postman (optional)
* Swagger (http://localhost:8080/swagger-ui/index.html)

## Run locally

In terminal:

```
$ mvn clean spring-boot:run
```

In IntelliJ Idea: Right click on `Application` -> "Run Application"

## Running tests

```
$ mvn verify
```

## Test manually

In terminal:

```
curl -X POST 'http://localhost:8080/greetings' \
  -H 'Content-Type: application/json' \
  --data '{
    "name": "Joe"
  }'
```


