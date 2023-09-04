package com.company.hr.service;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.LoggerConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.dto.links.HRef;
import com.company.hr.dto.links.Links;
import com.company.hr.exception.RecordNotFoundException;
import com.company.hr.mapper.EmployeeMapper;
import com.company.hr.model.Employee;
import com.company.hr.repository.EmployeeRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private static final String SELF_REF_ROOT_LINK = EndpointConstants.V1_ROOT_URI +
      EndpointConstants.EMPLOYEES_ROOT_URI + "/";

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  public List<EmployeeDto> getCollectionOfEmployees(int size, int offset) {

    PageRequest pageRequest = PageRequest.of(offset, size);
    Page<Employee> employees = employeeRepository.findAll(pageRequest);

    return employees.stream()
        .map(employeeMapper::mapEmployeeModelToDto)
        .collect(Collectors.toList());
  }

  public EmployeeDto getEmployeeById(Integer id) {

    Employee employee = employeeRepository
        .findById(id)
        .orElseThrow(
            () -> new RecordNotFoundException("No employee record with that ID could be found.",
                id));
    return employeeMapper.mapEmployeeModelToDto(employee);
  }

  public EmployeeDto saveNewEmployee(EmployeeSaveDto request) {

    Employee employee = employeeMapper.mapEmployeeDtoToModel(request);
    employee.setUpdateTs(Timestamp.from(Instant.now()));
    employee.setUpdateUserId(MDC.get(LoggerConstants.MDC_APP_NAME_KEY));
    Employee result = employeeRepository.save(employee);
    EmployeeDto employeeDto = employeeMapper.mapEmployeeModelToDto(result);
    employeeDto.set_links(Links.builder()
        .self(HRef.builder()
            .href(SELF_REF_ROOT_LINK + employeeDto.getId())
            .build())
        .build());

    return employeeDto;
  }
}