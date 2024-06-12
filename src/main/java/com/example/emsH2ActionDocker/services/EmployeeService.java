package com.example.emsH2ActionDocker.services;

import com.example.emsH2ActionDocker.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(EmployeeDto updatedEmployeeDto, long id);

    void deleteEmployee(long id);
}
