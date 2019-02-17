package com.strategicimperatives.HRApp.controllers;

import com.strategicimperatives.HRApp.entities.Employee;
import com.strategicimperatives.HRApp.serviceImpl.EmployeeServiceImpl;
import com.strategicimperatives.HRApp.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    ProjectServiceImpl projectService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ResponseEntity addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee successfully added");
    }

    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public ResponseEntity listAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @RequestMapping(value = "/delEmployee", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(long employeeId) {
        Employee emp = employeeService.getById(employeeId);
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee " + emp.getFirstName() + " " + emp.getLastName() + " has been removed");
    }
    @RequestMapping(value = "/updateEmployee" , method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(Employee employee){
            employeeService.updateEmployee(employee);
            return ResponseEntity.ok(employee.getFirstName() + " " + employee.getLastName() + " has been updated");
    }
}
