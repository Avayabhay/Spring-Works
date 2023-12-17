package com.crud4.cruddemo.rest;


import com.crud4.cruddemo.dao.EmployeeDAO;
import com.crud4.cruddemo.dao.EmployeeDAOJpaImpl;
import com.crud4.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;
    //quick and dirty: inject employeeDAO
 
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    //expose the /employees to get the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAl();
    }

}
