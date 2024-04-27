package com.luv2code.springboot.cruddemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeRestController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login-page";
    }


}














