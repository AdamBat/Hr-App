package com.strategicimperatives.HRApp.service;

import com.strategicimperatives.HRApp.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getById(long id);

    List<Employee> findAll();

    Employee findByLastName(String lastName);

    Employee addEmployee(Employee employee);

    void deleteEmployee(long id);

    void updateEmployee(Employee employee);

}
