package com.bankManagementSystem.bankManagementSystem.service.implmentation;

import com.bankManagementSystem.bankManagementSystem.dto.EmployeeDto;
import com.bankManagementSystem.bankManagementSystem.entity.EmployeeEntity;
import com.bankManagementSystem.bankManagementSystem.exception.ResourceNotFoundException;
import com.bankManagementSystem.bankManagementSystem.mapper.EmployeeMapper;
import com.bankManagementSystem.bankManagementSystem.repository.EmployeeRepository;
import com.bankManagementSystem.bankManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employeeEntity = EmployeeMapper.mapEmployeeDtoToEmployeeEntity(employeeDto);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return EmployeeMapper.mapEmployeeEntityToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return EmployeeMapper.mapEmployeeEntityToEmployeeDto(employeeEntity);
    }
}
