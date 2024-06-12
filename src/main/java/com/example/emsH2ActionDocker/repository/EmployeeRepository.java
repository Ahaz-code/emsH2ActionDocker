package com.example.emsH2ActionDocker.repository;

import com.example.emsH2ActionDocker.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
