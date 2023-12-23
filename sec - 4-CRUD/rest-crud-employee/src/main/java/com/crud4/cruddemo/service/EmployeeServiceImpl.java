package com.crud4.cruddemo.service;

import com.crud4.cruddemo.dao.EmployeeDAO;
import com.crud4.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Inject the EmployeeDAO
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //Implement the findAll()
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAl();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return this.employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employeeDAO.deleteEmployee(id);

    }
}
