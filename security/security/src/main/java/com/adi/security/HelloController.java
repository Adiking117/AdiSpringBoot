package com.adi.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        return "Hello Adi security app";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String getHelloUser(){
        return "Hello Adi security app - USER";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getHelloAdmin(){
        return "Hello Adi security app - ADMIN";
    }
}
