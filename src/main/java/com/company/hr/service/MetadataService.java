package com.company.hr.service;

import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.MetadataMapper;
import com.company.hr.model.Department;
import com.company.hr.model.EmployeeStatus;
import com.company.hr.model.EmployeeTitle;
import com.company.hr.model.EmployeeType;
import com.company.hr.repository.DepartmentRepository;
import com.company.hr.repository.EmployeeStatusRepository;
import com.company.hr.repository.EmployeeTitleRepository;
import com.company.hr.repository.EmployeeTypeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetadataService {

  private final DepartmentRepository departmentRepository;
  private final EmployeeStatusRepository employeeStatusRepository;
  private final EmployeeTitleRepository employeeTitleRepository;
  private final EmployeeTypeRepository employeeTypeRepository;
  private final MetadataMapper metadataMapper;

  public List<MetadataRecord> getAllDepartments() {

    List<Department> departments = departmentRepository.findAll();
    return metadataMapper.mapDepartmentModelsToDto(departments);
  }

  public MetadataRecord getDepartmentById(Integer id) {

    Department department = departmentRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException("No department record with that ID could be found.", id));
    return metadataMapper.mapDepartmentToDto(department);
  }

  public List<MetadataRecord> getAllEmployeeStatuses() {

    List<EmployeeStatus> employeeStatuses = employeeStatusRepository.findAll();
    return metadataMapper.mapEmployeeStatusModelsToDto(employeeStatuses);
  }

  public MetadataRecord getEmployeeStatusById(Integer id) {

    EmployeeStatus employeeStatus = employeeStatusRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException("No employee status record with that ID could be found.", id));
    return metadataMapper.mapEmployeeStatusToDto(employeeStatus);
  }

  public List<MetadataRecord> getAllEmployeeTitles() {

    List<EmployeeTitle> employeeTitles = employeeTitleRepository.findAll();
    return metadataMapper.mapEmployeeTitleModelsToDto(employeeTitles);
  }

  public MetadataRecord getEmployeeTitleById(Integer id) {

    EmployeeTitle employeeTitle = employeeTitleRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException("No employee title record with that ID could be found.", id));
    return metadataMapper.mapEmployeeTitleModelToDto(employeeTitle);
  }

  public List<MetadataRecord> getAllEmployeeTypes() {

    List<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
    return metadataMapper.mapEmployeeTypeModelsToDto(employeeTypes);
  }

  public MetadataRecord getEmployeeTypeById(Integer id) {

    EmployeeType employeeType = employeeTypeRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException("No employee type record with that ID could be found.", id));
    return metadataMapper.mapEmployeeTypeToDto(employeeType);
  }
}