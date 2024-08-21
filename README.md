# URL Shortener

Template project for URL Shortener service.

## Local setup

Please install the following:

* Maven
* Java 17+
* Curl
* Postman (optional)

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


