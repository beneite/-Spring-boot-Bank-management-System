package com.bankManagementSystem.bankManagementSystem.service.implmentation;

import com.bankManagementSystem.bankManagementSystem.dto.EmployeeDto;
import com.bankManagementSystem.bankManagementSystem.entity.EmployeeEntity;
import com.bankManagementSystem.bankManagementSystem.exception.DuplicateEmailException;
import com.bankManagementSystem.bankManagementSystem.exception.ResourceNotFoundException;
import com.bankManagementSystem.bankManagementSystem.mapper.EmployeeMapper;
import com.bankManagementSystem.bankManagementSystem.repository.EmployeeRepository;
import com.bankManagementSystem.bankManagementSystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        return employeeEntityList.stream().map( EmployeeEntity -> EmployeeMapper.mapEmployeeEntityToEmployeeDto(EmployeeEntity)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        EmployeeEntity existingData = employeeRepository.findById(employeeDto.getEmployeeId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", employeeDto.getEmployeeId())
        );
        // setting the new data to the existing one
        existingData.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
        existingData.setEmployeeLastName(employeeDto.getEmployeeLastName());
        existingData.setEmployeeEmail(employeeDto.getEmployeeEmail());

        Optional<EmployeeEntity> ifEmailExist = employeeRepository.findByEmployeeEmail(employeeDto.getEmployeeEmail());     // check if email exist in DB
        if(ifEmailExist.isPresent()){
            throw new DuplicateEmailException(String.format("Email: %s, already available.", employeeDto.getEmployeeEmail()));
        }

        // saving the data
        EmployeeEntity savedUser = employeeRepository.save(existingData);
        return EmployeeMapper.mapEmployeeEntityToEmployeeDto(savedUser);
    }
}
