package com.strategicimperatives.HRApp;

import com.strategicimperatives.HRApp.entities.Employee;
import com.strategicimperatives.HRApp.repositories.EmployeeRepository;
import com.strategicimperatives.HRApp.serviceImpl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    private Employee employee;
    private Employee employee2;

    @Before
    public void setup() {
        employee = new Employee("Adam", "Bator", 50000, "developer");
        employee.setId(1L);
        employee2  = new Employee("John","Doe",55000,"project manager");
        employee2.setId(2L);

        when(employeeRepository.getOne(1L)).thenReturn((employee));


    }

    @Test
    public void addEmployeeTest() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.addEmployee(employee)).isEqualTo(employee);
    }

    @Test
    public void getEmployeeByIdTest() {
        assertThat(employeeService.getById(1L)).isEqualTo(employee);
    }

    @Test
    public void listAllEmployeesTest(){
            List<Employee> employeeList = new ArrayList<>();
            employeeList.add(employee);
            employeeList.add(employee);
            when(employeeRepository.findAll()).thenReturn(employeeList);
            assertThat(employeeService.findAll()).isEqualTo(employeeList);
    }



}
