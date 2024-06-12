package com.example.emsH2ActionDocker.services.impl;

import com.example.emsH2ActionDocker.dto.EmployeeDto;
import com.example.emsH2ActionDocker.entity.Employee;
import com.example.emsH2ActionDocker.exceptions.ResourceNotFoundException;
import com.example.emsH2ActionDocker.mapper.EmployeeMapper;
import com.example.emsH2ActionDocker.repository.EmployeeRepository;
import com.example.emsH2ActionDocker.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee); // it returns the saved employee that contains id

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee with Id "+employeeId+" doesn't exist"));

       return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }
    @Override
    public EmployeeDto updateEmployee(EmployeeDto updatedEmployeeDto, long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee with id"+id+"not found"));
        employee.setEmail(updatedEmployeeDto.getEmail());
        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());

        Employee updatedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee with id "+id+"doesn't exist"));
        employeeRepository.deleteById(id);
    }


}
