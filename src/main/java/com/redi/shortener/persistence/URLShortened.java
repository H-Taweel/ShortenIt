package com.redi.shortener.persistence;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// import javax.persistence.*;

@Entity
@Table(name = "Url_Shortened")
public class URLShortened {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "URL")
  private String url;

  private String key;
  private LocalDateTime validUntil;

  //  public URLShortened() {}

  public URLShortened() {
    this.id = id;
    this.url = url;
    this.key = key;
    this.validUntil = validUntil;
  }

  public Long getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public String getKey() {
    return key;
  }

  public LocalDateTime getValidUntil() {
    return validUntil;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setValidUntil(LocalDateTime validUntil) {
    this.validUntil = validUntil;
  }
}
