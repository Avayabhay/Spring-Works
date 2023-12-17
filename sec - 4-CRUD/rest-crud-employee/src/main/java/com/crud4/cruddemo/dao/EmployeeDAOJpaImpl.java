package com.crud4.cruddemo.dao;

import com.crud4.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // Define Fields for EntityManager
    private EntityManager entityManager;

    //set up Constructor Injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAl() {

        //create Query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //Execute the query to get results
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;

    }
}
