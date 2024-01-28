package com.rishabh.basicauthentication_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String home()
    {
        return "<h1>Hey, Welcome to Spring Security 6</h1>";
    }
}
