package com.demo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String startSever(){
        return "The Serer has started!!!";
    }
    @GetMapping("/demo")
    public String getDemo(){
        return "THis is the second Mapping created using Spring Boot";
    }
}
