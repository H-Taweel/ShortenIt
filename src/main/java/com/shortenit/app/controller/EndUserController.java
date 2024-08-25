package com.shortenit.app.controller;

import com.shortenit.app.model.EndUser;
import com.shortenit.app.model.EndUserRegistration;
import com.shortenit.app.services.EndUserService;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EndUserController {
  @Autowired EndUserService service;

  @PostMapping("/users")
  public EndUser post(@RequestBody final EndUserRegistration registration) {
    return service.create(registration);
  }

  @GetMapping("/users/{id}")
  public Optional<EndUser> get(@PathVariable final UUID id) {
    return service.get(id);
  }
}
