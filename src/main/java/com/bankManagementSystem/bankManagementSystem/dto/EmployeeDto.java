package com.bankManagementSystem.bankManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private String employeeEmail;
}
