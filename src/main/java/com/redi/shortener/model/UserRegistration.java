package com.redi.shortener.model;


 public record UserRegistration(String name, String email) {}


//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Data
//@RequiredArgsConstructor
//public class UserRegistration {
//  private final String username;
//  private final String password;
//  private final String fullname;
//
//  public UserI toUser(PasswordEncoder encoder) {
//    return UserI.builder()
//        .username(username)
//        .password(encoder.encode(password))
//        .fullName(fullname)
//        .build();
//  }
//}
