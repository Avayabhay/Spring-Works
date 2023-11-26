package com.demo2.demo2;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy   
public class CricketCoach implements ICoach{

    public CricketCoach(){
        System.out.println(this.getClass().getName());
    }
    public String dailyWorkOut(){
        return "Do 15 pull ups daily!!";
    }
}

