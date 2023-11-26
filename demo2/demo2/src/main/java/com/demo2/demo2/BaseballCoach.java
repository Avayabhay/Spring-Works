package com.demo2.demo2;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class BaseballCoach implements ICoach{

    public BaseballCoach(){
        System.out.println(this.getClass().getName());
    }
    @Override
    public String dailyWorkOut() {
        return "Practise throwing Balls for 30mins";
    }
}
