package com.demo3.cruddemo.dao;

import com.demo3.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentImplement implements StudentDAO{

    //    Define field for entity Manager
    private EntityManager entityManager;

    //      inject Entity Manager using Constructor Injection
    @Autowired
    public StudentImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //      Implement the save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findByID(int id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // Return Query result
        return theQuery.getResultList();
//        return  null;
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData",lastName);
        //return results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student myStudent) {
        entityManager.merge(myStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(int  studentID) {
            Student theStudent = entityManager.find(Student.class, studentID);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteStudentAll() {
       return entityManager.createQuery("DELETE FROM Student").executeUpdate();
//         = query.executeUpdate();
//        System.out.println(rows+ " rows deleted from the Table");
    }
}
