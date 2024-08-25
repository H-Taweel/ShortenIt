package com.shortenit.app.controller;

import com.shortenit.app.model.CreateShortURLRequest;
import com.shortenit.app.model.CreateShortURLResponse;
import com.shortenit.app.model.ExpandShortURLResponse;
import com.shortenit.app.services.URLShortenerService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLShortenerController {
  @Autowired URLShortenerService urlShortenerService;

  @PostMapping("/short-links")
  public CreateShortURLResponse shorten(@RequestBody final CreateShortURLRequest request) {
    return urlShortenerService.create(request);
  }

  @GetMapping("/{key}")
  public ResponseEntity<ExpandShortURLResponse> expand(@PathVariable final String key)
      throws URISyntaxException {
    try {
      ExpandShortURLResponse expandResponse = urlShortenerService.expand(key);
      return ResponseEntity.ok(expandResponse);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(null); // handle expired or missing URLs
    }
  }

  //  **********the following code would help to redirect according to URL HTTP
  // response*************

  //  @GetMapping("/{key}")
  //  public void expand(@PathVariable final String key, HttpServletResponse response)
  //      throws URISyntaxException, IOException {
  //    try {
  //      // Call the service to expand the short URL key
  //      ExpandShortURLResponse expandResponse = urlShortenerService.expand(key);
  //
  //      // Redirect to the long URL
  //      response.sendRedirect(expandResponse.longURL().toString());
  //    } catch (URISyntaxException e) {
  //      // Handle invalid URIs
  //      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL");
  //    } catch (RuntimeException e) {
  //      // Handle expired or not found URLs
  //      response.sendError(
  //          HttpServletResponse.SC_NOT_FOUND, "Short URL has expired or does not exist");
  //    }
  //  }
  //    @GetMapping("/{key}")
  //    public ExpandShortURLResponse expand(@PathVariable final String key, HttpServletResponse
  //   response)
  //        throws URISyntaxException, IOException {
  //      ExpandShortURLResponse expandResponse = urlShortenerService.expand(key);
  //      response.sendRedirect(expandResponse.longURL().toString());
  //      //    response.setStatus(301);
  //      //    ExpandShortURLResponse expandResponse = urlShortenerService.expand(key);
  //      //    response.setHeader("Location", expandResponse.longURL().toString());
  //      return urlShortenerService.expand(key);
  //    }
}
