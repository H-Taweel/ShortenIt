package com.redi.shortener.controller;

import com.redi.shortener.model.UserRegistration;
import com.redi.shortener.model.UserI;
import com.redi.shortener.services.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired private UserService userService;

  @PostMapping("/users")
  public ResponseEntity<UserI> createUser(@RequestBody UserRegistration userRegistration) {
    UserI createdUser = userService.create(userRegistration);
//    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    return ResponseEntity.ok(createdUser);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<UserI> getUser(@PathVariable UUID id) {
    UserI user = userService.get(id);
    return ResponseEntity.ok(user);
  }
}

//  @PostMapping("/users")
//  public UserI post(@RequestBody final UserRegistration registration) {
//    return userService.create(registration);
//  }
//
//  @GetMapping("/users/{id}")
//  public ResponseEntity<UserI> get(@PathVariable final UUID id) {
//    return ResponseEntity.userService.get(id);
//  }