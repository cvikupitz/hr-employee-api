package com.company.hr.repository;

import com.company.hr.model.EmployeeTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTitleRepository extends JpaRepository<EmployeeTitle, Integer> {

}