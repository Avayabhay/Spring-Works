package com.crud4.cruddemo.dao;

import com.crud4.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAl();

    Employee findById(int id);

    public Employee save(Employee theEmployee);

    public void deleteEmployee(int id);
}
