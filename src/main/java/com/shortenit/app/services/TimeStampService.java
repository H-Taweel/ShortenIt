package com.redi.shortener.services;

import com.redi.shortener.model.TimeStamping;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class TimeStampService {
  public TimeStamping createTimeStamp() {
    return new TimeStamping(Instant.now());
  }
}
