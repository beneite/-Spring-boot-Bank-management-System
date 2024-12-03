package com.bankManagementSystem.bankManagementSystem.mapper;

import com.bankManagementSystem.bankManagementSystem.dto.EmployeeDto;
import com.bankManagementSystem.bankManagementSystem.entity.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDto mapEmployeeEntityToEmployeeDto(EmployeeEntity employeeEntity){
        return new EmployeeDto(
                employeeEntity.getEmployeeId(),
                employeeEntity.getEmployeeFirstName(),
                employeeEntity.getEmployeeLastName(),
                employeeEntity.getEmployeeEmail()
        );
    }

    public static EmployeeEntity mapEmployeeDtoToEmployeeEntity(EmployeeDto employeeDto){
        return new EmployeeEntity(
                employeeDto.getEmployeeId(),
                employeeDto.getEmployeeFirstName(),
                employeeDto.getEmployeeLastName(),
                employeeDto.getEmployeeEmail()
        );
    }
}
