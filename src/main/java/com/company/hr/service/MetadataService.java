package com.company.hr.service;

import com.company.hr.dto.EmployeeTitleDto;
import com.company.hr.dto.MetadataRecord;
import com.company.hr.mapper.MetadataMapper;
import com.company.hr.model.EmployeeStatus;
import com.company.hr.model.EmployeeTitle;
import com.company.hr.model.EmployeeType;
import com.company.hr.repository.EmployeeStatusRepository;
import com.company.hr.repository.EmployeeTitleRepository;
import com.company.hr.repository.EmployeeTypeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetadataService {

  private final EmployeeStatusRepository employeeStatusRepository;
  private final EmployeeTitleRepository employeeTitleRepository;
  private final EmployeeTypeRepository employeeTypeRepository;
  private final MetadataMapper metadataMapper;

  public List<MetadataRecord> getAllEmployeeStatuses() {

    List<EmployeeStatus> employeeStatuses = employeeStatusRepository.findAll();
    return metadataMapper.mapEmployeeStatusModelsToDto(employeeStatuses);
  }

  public MetadataRecord getEmployeeStatusById(Integer id) {

    EmployeeStatus employeeStatus = employeeStatusRepository.findById(id).orElseThrow();
    return metadataMapper.mapEmployeeStatusToDto(employeeStatus);
  }

  public List<EmployeeTitleDto> getAllEmployeeTitles() {

    List<EmployeeTitle> employeeTitles = employeeTitleRepository.findAll();
    return metadataMapper.mapEmployeeTitleModelsToDto(employeeTitles);
  }

  public EmployeeTitleDto getEmployeeTitleById(Integer id) {

    EmployeeTitle employeeTitle = employeeTitleRepository.findById(id).orElseThrow();
    return metadataMapper.mapEmployeeTitleModelToDto(employeeTitle);
  }

  public List<MetadataRecord> getAllEmployeeTypes() {

    List<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
    return metadataMapper.mapEmployeeTypeModelsToDto(employeeTypes);
  }

  public MetadataRecord getEmployeeTypeById(Integer id) {

    EmployeeType employeeType = employeeTypeRepository.findById(id).orElseThrow();
    return metadataMapper.mapEmployeeTypeToDto(employeeType);
  }
}