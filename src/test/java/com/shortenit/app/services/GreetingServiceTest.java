package com.shortenit.app.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.shortenit.app.model.CreateGreetingRequest;
import org.junit.jupiter.api.Test;

class GreetingServiceTest {

  final String name = "John";
  final GreetingService service = new GreetingService();
  final CreateGreetingRequest request = new CreateGreetingRequest(name);

  @Test
  void greet() {
    assertThat(service.create(request).name(), equalTo(name));
  }
}
