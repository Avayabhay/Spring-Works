package com.demo2.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demo2Controller {

    @Value("${variable.a}")
    private String Hi;
    @GetMapping("/")
    public String getDemo2(){
        return "Server Started!! " +  Hi;
    }
}
