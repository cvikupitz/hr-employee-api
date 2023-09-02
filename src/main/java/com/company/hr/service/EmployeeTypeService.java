package com.company.hr.service;

import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.EmployeeTypeMapper;
import com.company.hr.model.EmployeeType;
import com.company.hr.repository.EmployeeTypeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeTypeService {

  private final EmployeeTypeRepository employeeTypeRepository;
  private final EmployeeTypeMapper employeeTypeMapper;

  public List<MetadataRecord> getAllEmployeeTypes() {

    List<EmployeeType> employeeTypes = employeeTypeRepository.findAll();
    return employeeTypeMapper.mapEmployeeTypeModelsToDto(employeeTypes);
  }

  public MetadataRecord getEmployeeTypeById(Integer id) {

    EmployeeType employeeType = employeeTypeRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException(
            "No employee type record with that ID could be found.", id));
    return employeeTypeMapper.mapEmployeeTypeToDto(employeeType);
  }
}