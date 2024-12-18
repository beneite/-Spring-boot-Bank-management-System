package com.bankManagementSystem.bankManagementSystem.controller;

import com.bankManagementSystem.bankManagementSystem.dto.EmployeeDto;
import com.bankManagementSystem.bankManagementSystem.service.implmentation.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getEmployeeApi(){
        List<EmployeeDto> returnedAllEmployeeListDtoResponse = employeeService.getAllEmployees();
        return new ResponseEntity<>(returnedAllEmployeeListDtoResponse, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeDetailsApi(@PathVariable("id") Long userId,@RequestBody EmployeeDto employeeDto){
        employeeDto.setEmployeeId(userId);
        EmployeeDto updatedUser = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployeeApi(@PathVariable("id") Long userId){
        employeeService.deleteUser(userId);
        return new ResponseEntity<>("User with id:"+userId+" Deleted", HttpStatus.OK);
    }

}
