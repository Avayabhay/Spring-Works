package com.example.crudApp.rest;

import com.example.crudApp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/app")
public class StudentRestController {

    public ArrayList<Student> studentList;

    @PostConstruct
    public void createList(){
        studentList = new ArrayList<Student>();
        studentList.add(new Student("Sandra","Bugg"));
        studentList.add(new Student("Mendes","Shawn"));
        studentList.add(new Student("Justin","Timerlake"));
    }

    @GetMapping("/test")
    public String test(){
        return "Hello World!!";
    }

    @GetMapping("/student")
    public List<Student> getStudents(){

        return studentList;
    }

    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        return studentList.get(studentID);
    }
}


