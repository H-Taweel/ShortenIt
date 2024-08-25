package com.shortenit.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.shortenit.app.services.EndUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EndEndUserControllerTest {
  @Autowired private MockMvc mockMvc;

  @Autowired private EndUserService endUserService;

  @Test
  void createUsers() throws Exception {
    final String body =
        """
            {"name": "Jose", "email": "jose@example.com"}""";

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
        .andExpect(status().isOk());
  }
}
