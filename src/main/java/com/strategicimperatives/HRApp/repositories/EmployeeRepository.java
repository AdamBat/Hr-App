package com.strategicimperatives.HRApp.repositories;

import com.strategicimperatives.HRApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByLastName(String lastName);
}
