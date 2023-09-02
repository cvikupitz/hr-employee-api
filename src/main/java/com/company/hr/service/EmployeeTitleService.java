package com.company.hr.service;

import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.EmployeeTitleMapper;
import com.company.hr.model.EmployeeTitle;
import com.company.hr.repository.EmployeeTitleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeTitleService {

  private final EmployeeTitleRepository employeeTitleRepository;
  private final EmployeeTitleMapper employeeTitleMapper;

  public List<MetadataRecord> getAllEmployeeTitles() {

    List<EmployeeTitle> employeeTitles = employeeTitleRepository.findAll();
    return employeeTitleMapper.mapEmployeeTitleModelsToDto(employeeTitles);
  }

  public MetadataRecord getEmployeeTitleById(Integer id) {

    EmployeeTitle employeeTitle = employeeTitleRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException(
            "No employee title record with that ID could be found.", id));
    return employeeTitleMapper.mapEmployeeTitleModelToDto(employeeTitle);
  }
}