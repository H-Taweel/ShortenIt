package com.shortenit.app.controller;

import com.shortenit.app.model.CreateShortURLRequest;
import com.shortenit.app.model.CreateShortURLResponse;
import com.shortenit.app.model.ExpandShortURLResponse;
import com.shortenit.app.services.URLShortenerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1") // Base path for all endpoints
public class URLShortenerController {

  @Autowired private URLShortenerService urlShortenerService;

  @Operation(
      summary = "Create a short URL",
      description =
          "Shortens a given URL and returns the shortened URL along with its validity period.")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Short URL created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request parameters"),
        @ApiResponse(responseCode = "409", description = "URL already shortened")
      })
  @PostMapping("/short-links")
  public CreateShortURLResponse shorten(@RequestBody final CreateShortURLRequest request) {
    return urlShortenerService.create(request);
  }

  @Operation(
      summary = "Expand a short URL",
      description = "Expands a given short URL key and returns the original long URL.")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Short URL expanded successfully"),
        @ApiResponse(responseCode = "404", description = "Short URL not found or expired")
      })
  @GetMapping("/{key}")
  public ResponseEntity<ExpandShortURLResponse> expand(@PathVariable final String key)
      throws URISyntaxException {
    try {
      ExpandShortURLResponse expandResponse = urlShortenerService.expand(key);
      return ResponseEntity.ok(expandResponse);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(null); // Handle expired or missing URLs
    }
  }
}
