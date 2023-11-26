package com.demo2.demo2;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements ICoach{

    public BasketballCoach(){
        System.out.println(this.getClass().getName());
    }
    @Override
    public String dailyWorkOut() {
        return "practise basketing for 30mins";
    }
}
