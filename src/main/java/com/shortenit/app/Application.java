package com.shortenit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.shortenit.app.repository")
@EntityScan(basePackages = "com.shortenit.app.model")
public class ShortenItApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShortenItApplication.class, args);
  }
}
