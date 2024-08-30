package com.shortenit.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String index() {
        return "index";  // This maps to the welcome.html template
    }
    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";  // This maps to the welcome.html template
    }
        @GetMapping("/next")
    public String next() {
        // Logic for the next page, if any
        return "nextPage";  // Replace with your actual next page template
    }
}
