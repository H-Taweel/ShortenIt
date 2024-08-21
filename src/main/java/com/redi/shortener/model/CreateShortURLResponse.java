package com.redi.shortener.model;

import java.net.URI;
import java.time.LocalDateTime;

public record CreateShortURLResponse(URI shortURL, LocalDateTime validUntil) {}
