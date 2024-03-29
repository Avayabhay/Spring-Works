package com.demo3.cruddemo.dao;

import com.demo3.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student theStudent);

    public Student findByID(int id);


    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public void updateStudent(Student myStudent);

    public void deleteStudent(int studentID);

    public int deleteStudentAll();
}
