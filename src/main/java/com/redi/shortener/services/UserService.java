package com.redi.shortener.services;

import com.redi.shortener.model.UserRegistration;
import com.redi.shortener.model.UserI;
import com.redi.shortener.repository.UserRepository;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserI create(final UserRegistration registration) {
    Optional<UserI> existingUser = userRepository.findByEmail(registration.email().toLowerCase());
    if (existingUser.isPresent()) {
      throw new RuntimeException("User already exists with email: " + registration.email());
    }

    final UUID id = UUID.randomUUID();
    final UserI user = new UserI(
            id,
            UserService.capitalizeWord(registration.name()),
            registration.email().toLowerCase()
    );

    return userRepository.save(user);
  }

  public UserI get(final UUID userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));
  }

  public static String capitalizeWord(String str) {
    return Arrays.stream(str.split("\\s+"))
        .map(t -> t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase())
        .collect(Collectors.joining(" "));
  }
}
