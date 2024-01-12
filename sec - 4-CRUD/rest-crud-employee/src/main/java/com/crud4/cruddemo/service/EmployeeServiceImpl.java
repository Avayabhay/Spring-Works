package com.crud4.cruddemo.service;

import com.crud4.cruddemo.dao.EmployeeRepository;
import com.crud4.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Inject the EmployeeDAO
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Implement the findAll()
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee;
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("Cannot find the employee with ID : "+id);
        }
        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return this.employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteById(id);

    }
}
