package com.shortenit.app.services;

import com.shortenit.app.model.TimeStamping;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class TimeStampService {
  public TimeStamping createTimeStamp() {
    return new TimeStamping(Instant.now());
  }
}
