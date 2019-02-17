package com.strategicimperatives.HRApp;

import com.strategicimperatives.HRApp.entities.Employee;
import com.strategicimperatives.HRApp.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    EmployeeRepository employeeRepository;

    private Employee employee;
    private Employee empSaved;

    @Test
    public void saveEmployeeTest() {
        employee = new Employee("Adam", "Bator", 50000, "developer");
        empSaved = testEntityManager.persist(employee);
        Employee empFromDB = employeeRepository.findEmployeeByLastName("Bator");
        assertThat(empSaved).isEqualTo(empFromDB);
    }

    @Test
    public void getAllEmployeesTest() {
        employee = new Employee("Adam", "Bator", 50000, "developer");
        testEntityManager.persist(employee);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        assertThat(employeeList).isEqualTo(employeeRepository.findAll());
    }

    @Test
    public void deleteEmployeeTest() {
        employee = new Employee("Adam", "Bator", 50000, "developer");
        testEntityManager.persist(employee);
        Employee secondEmp = new Employee("John", "Doe", 55000, "project manager");
        testEntityManager.persist(secondEmp);
        Employee empToDelete = employeeRepository.findEmployeeByLastName("Bator");
        employeeRepository.delete(empToDelete);
        assertThat(1).isEqualTo(employeeRepository.findAll().size());
    }

    @Test
    public void findByLastName() {
        employee = new Employee("Adam", "Bator", 50000, "developer");
        testEntityManager.persist(employee);
        Employee foundInDb = employeeRepository.findEmployeeByLastName("Bator");
        assertThat(employee).isEqualTo(foundInDb);
    }
}
