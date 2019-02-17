package com.strategicimperatives.HRApp.serviceImpl;

import com.strategicimperatives.HRApp.entities.Employee;
import com.strategicimperatives.HRApp.repositories.EmployeeRepository;
import com.strategicimperatives.HRApp.repositories.ProjectRepository;
import com.strategicimperatives.HRApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository empRepo;
    @Autowired
    ProjectRepository projectRepo;

    @Override
    public Employee getById(long id) {
        return empRepo.getOne(id);
    }

    @Override
    public List<Employee> findAll() {
        return empRepo.findAll();
    }

    @Override
    public Employee findByLastName(String lastName) {
        return empRepo.findEmployeeByLastName(lastName);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee.getProject() != null) {
            employee.setProject(projectRepo.getOne(employee.getProject().getId()));
        }
        return empRepo.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        empRepo.delete(empRepo.getOne(id));
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee emp = empRepo.getOne(employee.getId());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setJobTitle(employee.getJobTitle());
        emp.setProject(employee.getProject());
        emp.setSalary(employee.getSalary());
        empRepo.save(employee);
    }
}
