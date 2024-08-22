package com.redi.shortener.services;

import com.redi.shortener.model.UserI;
import com.redi.shortener.model.UserRegistration;
import com.redi.shortener.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void shouldCreateUserWithRegistrationName() {
    final UserRegistration registration = new UserRegistration("Joe", "joe@example.com");
    final UUID userId = UUID.randomUUID();
    final UserI user = new UserI(userId, registration.name(), registration.email());

    // Mock behavior
    when(userRepository.findByEmail(registration.email().toLowerCase())).thenReturn(Optional.empty());
    when(userRepository.save(any(UserI.class))).thenReturn(user);

    final UserI createdUser = userService.create(registration);

    assertThat(createdUser.getName(), equalTo(registration.name()));
    assertThat(createdUser.getEmail(), equalTo(registration.email()));
  }

  @Test
  void shouldCreateRandomIds() {
    final UserRegistration registration1 = new UserRegistration("Joe", "joe@example.com");
    final UserRegistration registration2 = new UserRegistration("Paul", "paul@example.com");

    final UUID userId1 = UUID.randomUUID();
    final UUID userId2 = UUID.randomUUID();

    UserI user1 = new UserI(userId1, registration1.name(), registration1.email());
    UserI user2 = new UserI(userId2, registration2.name(), registration2.email());

    // Mock behavior
    when(userRepository.findByEmail(registration1.email().toLowerCase())).thenReturn(Optional.empty());
    when(userRepository.findByEmail(registration2.email().toLowerCase())).thenReturn(Optional.empty());
    when(userRepository.save(any(UserI.class))).thenAnswer(invocation -> {
      UserI user = invocation.getArgument(0);
      if (user.getEmail().equals(registration1.email().toLowerCase())) {
        user.setId(userId1); // Ensure the user has the expected ID
        return user1;
      } else if (user.getEmail().equals(registration2.email().toLowerCase())) {
        user.setId(userId2); // Ensure the user has the expected ID
        return user2;
      } else {
        return null;
      }
    });

    final UserI createdUser1 = userService.create(registration1);
    final UserI createdUser2 = userService.create(registration2);

    assertThat(createdUser1.getId(), not(equalTo(createdUser2.getId())));
  }
}
