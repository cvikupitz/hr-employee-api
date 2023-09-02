package com.company.hr.service;

import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.DepartmentMapper;
import com.company.hr.model.Department;
import com.company.hr.repository.DepartmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

  private final DepartmentRepository departmentRepository;
  private final DepartmentMapper departmentMapper;

  public List<MetadataRecord> getAllDepartments() {

    List<Department> departments = departmentRepository.findAll();
    return departmentMapper.mapDepartmentModelsToDto(departments);
  }

  public MetadataRecord getDepartmentById(Integer id) {

    Department department = departmentRepository
        .findById(id)
        .orElseThrow(
            () -> new RecordNotFoundException("No department record with that ID could be found.",
                id));
    return departmentMapper.mapDepartmentToDto(department);
  }
}