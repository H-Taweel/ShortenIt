 package com.redi.shortener.controller;


 import com.redi.shortener.model.UserI;
 import com.redi.shortener.model.UserRegistration;
 import com.redi.shortener.repository.UserRepository;
 import lombok.AllArgsConstructor;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.crypto.password.PasswordEncoder;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;

 import java.util.Objects;
 import java.util.UUID;

 @Controller
 @RequestMapping("/register")
 @AllArgsConstructor
 public class UserRegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<UUID> processRegistration(@RequestBody final UserRegistration form){
        UserI user = userRepository.save(Objects.requireNonNull(form.toUser(passwordEncoder)));
        return ResponseEntity.status(200).body(user.getId());
    }
 }
