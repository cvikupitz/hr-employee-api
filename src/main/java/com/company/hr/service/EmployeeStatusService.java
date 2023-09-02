package com.company.hr.service;

import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.EmployeeStatusMapper;
import com.company.hr.model.EmployeeStatus;
import com.company.hr.repository.EmployeeStatusRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeStatusService {

  private final EmployeeStatusRepository employeeStatusRepository;
  private final EmployeeStatusMapper employeeStatusMapper;

  public List<MetadataRecord> getAllEmployeeStatuses() {

    List<EmployeeStatus> employeeStatuses = employeeStatusRepository.findAll();
    return employeeStatusMapper.mapEmployeeStatusModelsToDto(employeeStatuses);
  }

  public MetadataRecord getEmployeeStatusById(Integer id) {

    EmployeeStatus employeeStatus = employeeStatusRepository
        .findById(id)
        .orElseThrow(() -> new RecordNotFoundException(
            "No employee status record with that ID could be found.", id));
    return employeeStatusMapper.mapEmployeeStatusToDto(employeeStatus);
  }
}