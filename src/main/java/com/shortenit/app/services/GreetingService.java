package com.redi.shortener.services;

import com.redi.shortener.model.CreateGreetingRequest;
import com.redi.shortener.model.Greeting;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
  public Greeting create(final CreateGreetingRequest request) {
    return new Greeting(UUID.randomUUID(), request.name());
  }
}
