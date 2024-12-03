package com.bankManagementSystem.bankManagementSystem.service;

import com.bankManagementSystem.bankManagementSystem.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

     EmployeeDto addEmployee(EmployeeDto employeeDto);
     EmployeeDto getEmployeeById(Long employeeId);
     List<EmployeeDto> getAllEmployees();
     EmployeeDto updateEmployee(EmployeeDto employeeDto);

}
