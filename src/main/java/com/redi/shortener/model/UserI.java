package com.redi.shortener.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
public class UserI {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  public UserI() {}

  public UserI(UUID id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public void setId(UUID id) {
    this.id = id;
  }

    public void setName(String name) {
    this.name = name;
  }

    public void setEmail(String email) {
    this.email = email;
  }
}
