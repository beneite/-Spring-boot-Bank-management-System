package com.bankManagementSystem.bankManagementSystem.controller;

import com.bankManagementSystem.bankManagementSystem.dto.EmployeeDto;
import com.bankManagementSystem.bankManagementSystem.service.implmentation.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployeeApi(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDtoResponse = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDtoResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByIdApi(@PathVariable("id") Long employeeId){
        EmployeeDto returnedEmployeeDtoResponse = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(returnedEmployeeDtoResponse, HttpStatus.OK);
    }

}
