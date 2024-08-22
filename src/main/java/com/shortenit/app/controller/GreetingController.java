package com.redi.shortener.controller;

import com.redi.shortener.model.CreateGreetingRequest;
import com.redi.shortener.model.Greeting;
import com.redi.shortener.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  @Autowired GreetingService service;

  @PostMapping("/greetings")
  public Greeting greet(@RequestBody final CreateGreetingRequest request) {
    return service.create(request);
  }
}
