package com.bankManagementSystem.bankManagementSystem.repository;

import com.bankManagementSystem.bankManagementSystem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByEmployeeEmail(String email);

}
