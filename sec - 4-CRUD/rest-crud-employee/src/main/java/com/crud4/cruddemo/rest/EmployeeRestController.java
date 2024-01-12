package com.crud4.cruddemo.rest;


import com.crud4.cruddemo.entity.Employee;
import com.crud4.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeRestController {

    private EmployeeService employeeService;
    //quick and dirty: inject employeeDAO

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose the /employees to get the list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //exposing the API to get single Employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Cannot find Employee with ID: "+employeeId);
        }

        return theEmployee;
    }

    //exposing the Post endpoint for saving Employee
    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee theEmpoyee){

        // if Employee is already having an ID, set it to 0
        theEmpoyee.setId(0);
        Employee savedEmployee = this.employeeService.save(theEmpoyee);

        return savedEmployee;

    }

    //exposing the end point to update an EMployee
    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee updatedEmployee = this.employeeService.save(theEmployee);
        return updatedEmployee;

    }

    //exposing the endpoint to delete an employee
    @DeleteMapping("employees/{employeeID}")
    public void deleteEmployee(@PathVariable int employeeID){
        this.employeeService.deleteEmployee(employeeID);
    }

}
