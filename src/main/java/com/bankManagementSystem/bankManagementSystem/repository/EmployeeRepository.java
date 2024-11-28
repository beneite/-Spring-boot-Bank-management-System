package com.bankManagementSystem.bankManagementSystem.repository;

import com.bankManagementSystem.bankManagementSystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


}
