package com.shortenit.app.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.shortenit.app.model.EndUser;
import com.shortenit.app.model.EndUserRegistration;
import org.junit.jupiter.api.Test;

class EndEndUserServiceTest {
  final EndUserService service = new EndUserService();

  @Test
  void shouldCreateUserWithRegistrationName() {
    final EndUserRegistration registration = new EndUserRegistration("Jose", "jose@example.com");
    final EndUser endUser = service.create(registration);

    assertThat(endUser.name(), equalTo(registration.name()));
  }

  @Test
  void shouldCreateRandomIds() {
    final EndUserRegistration registration1 = new EndUserRegistration("Jose", "jose@example.com");
    final EndUserRegistration registration2 = new EndUserRegistration("Pedro", "pedro@example.com");
    final EndUser endUser1 = service.create(registration1);
    final EndUser endUser2 = service.create(registration2);
    assertThat(endUser1.id(), not(equalTo(endUser2.id())));
  }
}
