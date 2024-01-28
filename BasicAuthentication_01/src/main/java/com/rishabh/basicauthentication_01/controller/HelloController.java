package com.rishabh.basicauthentication_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home()
    {
        return "<h1>Hey, Welcome to Spring Security 6 Home Page</h1>";
    }


    @GetMapping("/hello")
    public String hello()
    {
        return "<h2>Hello, Welcome to Spring Security 6</h2>";
    }

    @GetMapping("/secured")
    public String securedMethod()
    {
        return "<h1>No one can access this method.</h1>";
    }
}
