package com.shortenit.app.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.shortenit.app.model.TimeStamping;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class TimeStampServiceTest {

  @Test
  void createTimeStamp() {
    TimeStampService service = new TimeStampService();
    final TimeStamping timeStamping = service.createTimeStamp();

    assertThat(timeStamping.timeStamp(), lessThanOrEqualTo(Instant.now())); // timestmp > now
  }
}
