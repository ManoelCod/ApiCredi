package com.credi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home() {
        return "Aplicação Spring Boot está rodando!";
    }
}