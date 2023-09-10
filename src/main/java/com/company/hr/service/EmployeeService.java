package com.company.hr.service;

import com.company.hr.constants.ConstraintConstants;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.dto.employee.EmployeeUpdateDto;
import com.company.hr.dto.employee.UpsertResult;
import com.company.hr.dto.links.HRef;
import com.company.hr.dto.links.Links;
import com.company.hr.dto.result.ResultSet;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.EmployeeMapper;
import com.company.hr.mapper.EmployeePatchMapper;
import com.company.hr.model.Employee;
import com.company.hr.repository.EmployeeRepository;
import com.company.hr.util.PageableUtils;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  public static final String SELF_REF_ROOT_LINK = EndpointConstants.V1_ROOT_URI +
      EndpointConstants.EMPLOYEES_ROOT_URI;

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;
  private final EmployeePatchMapper employeePatchMapper;

  public ResultSet<EmployeeDto> getCollectionOfEmployees(Map<String, String> requestParams) {

    PageRequest pageRequest = PageRequest.of(0, 2000);
    Page<Employee> employeePage = employeeRepository.findAll(pageRequest);

    List<EmployeeDto> employees = employeePage.stream()
        .map(employeeMapper::mapEmployeeModelToDto)
        .collect(Collectors.toList());

    return ResultSet.<EmployeeDto>builder()
        .results(employees)
        ._links(PageableUtils.generateLinksWithMetadata(employeePage, SELF_REF_ROOT_LINK))
        .count(employees.size())
        .total(employeePage.getTotalElements())
        .build();
  }

  public EmployeeDto getEmployeeById(String id) {

    Employee employee = employeeRepository
        .findById(id)
        .orElseThrow(
            () -> new RecordNotFoundException("No employee record with that ID could be found.",
                id));
    return employeeMapper.mapEmployeeModelToDto(employee);
  }

  public EmployeeDto saveEmployee(String updateUserId, EmployeeSaveDto request) {

    Employee employee = employeeMapper.mapEmployeeDtoToModel(request);
    employee.setId(
        RandomStringUtils.random(ConstraintConstants.EMPLOYEE_ID_LENGTH, ConstraintConstants.EMPLOYEE_ID_CHARS));
    employee.setUpdateTs(Timestamp.from(Instant.now()));
    employee.setUpdateUserId(updateUserId);
    Employee result = employeeRepository.save(employee);
    EmployeeDto employeeDto = employeeMapper.mapEmployeeModelToDto(result);
    employeeDto.set_links(Links.builder()
        .self(HRef.builder()
            .href(SELF_REF_ROOT_LINK + "/" + employeeDto.getId())
            .build())
        .build());

    return employeeDto;
  }

  public UpsertResult upsertEmployee(String id, String updateUserId, EmployeeSaveDto request) {

    Employee employee = employeeRepository.findById(id).orElse(null);
    boolean created;
    if (employee == null) {
      employee = employeeMapper.mapEmployeeDtoToModel(request);
      employee.setId(id);
      created = true;
    } else {
      employeeMapper.mapEmployeeDtoToExistingModel(employee, request);
      created = false;
    }
    employee.setUpdateTs(Timestamp.from(Instant.now()));
    employee.setUpdateUserId(updateUserId);
    employee = employeeRepository.save(employee);

    return UpsertResult.builder()
        .created(created)
        .employeeDto(employeeMapper.mapEmployeeModelToDto(employee))
        .build();
  }

  public EmployeeDto patchEmployee(String id, String updateUserId, EmployeeUpdateDto request) {

    Employee employee = employeeRepository
        .findById(id)
        .orElseThrow(
            () -> new RecordNotFoundException("No employee record with that ID could be found.",
                id));
    employeePatchMapper.patchEmployeeModel(employee, request);
    employee.setUpdateTs(Timestamp.from(Instant.now()));
    employee.setUpdateUserId(updateUserId);
    Employee result = employeeRepository.save(employee);

    return employeeMapper.mapEmployeeModelToDto(result);
  }

  public EmployeeDto deleteEmployee(String id) {

    Employee employee = employeeRepository
        .findById(id)
        .orElseThrow(
            () -> new RecordNotFoundException("No employee record with that ID could be found.",
                id));
    employeeRepository.deleteById(id);
    return employeeMapper.mapEmployeeModelToDto(employee);
  }
}