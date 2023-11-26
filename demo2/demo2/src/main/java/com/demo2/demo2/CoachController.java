package com.demo2.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private ICoach coach;

    public CoachController(){
        System.out.println(this.getClass().getName());
    }
//    @Autowired
//    CoachController(@Qualifier("basketballCoach") ICoach myCoach){
//        System.out.println(this.getClass().getName());
//        this.coach = myCoach;
//    }

    @Autowired
    CoachController(ICoach myCoach){
        System.out.println(this.getClass().getName());
        this.coach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkOut() {
        return this.coach.dailyWorkOut();
    }
}
