package com.example.crudApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class StudentRestController {

    @GetMapping("/test")
    public String test(){
        return "Hello World!!";
    }
}
