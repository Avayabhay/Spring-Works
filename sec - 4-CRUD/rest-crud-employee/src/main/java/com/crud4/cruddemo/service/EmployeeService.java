package com.crud4.cruddemo.service;

import com.crud4.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    public Employee save(Employee theEmployee);

    public void deleteEmployee(int id);
}
