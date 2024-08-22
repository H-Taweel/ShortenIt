package com.redi.shortener.model;


import org.springframework.security.crypto.password.PasswordEncoder;

public record UserRegistration(String name, String email) {
 public UserI toUser(PasswordEncoder passwordEncoder) {
     return null;
 }
}