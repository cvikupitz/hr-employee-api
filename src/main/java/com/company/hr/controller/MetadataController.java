package com.company.hr.controller;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.dto.ComprehensiveMetadata;
import com.company.hr.dto.EmployeeTitleDto;
import com.company.hr.dto.MetadataRecord;
import com.company.hr.service.MetadataService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(EndpointConstants.METADATA_ROOT_URI)
@Tag(name = "Metadata Controller")
public class MetadataController {

  private final MetadataService metadataService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ComprehensiveMetadata> getAllMetadata() {

    List<MetadataRecord> employeeStatuses = metadataService.getAllEmployeeStatuses();
    List<EmployeeTitleDto> employeeTitles = metadataService.getAllEmployeeTitles();
    List<MetadataRecord> employeeTypes = metadataService.getAllEmployeeTypes();
    ComprehensiveMetadata response = ComprehensiveMetadata.builder()
        .employeeStatuses(employeeStatuses)
        .employeeTitles(employeeTitles)
        .employeeTypes(employeeTypes)
        .build();

    return ResponseEntity.ok(response);
  }

  @GetMapping(value = EndpointConstants.EMPLOYEE_STATUSES_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<MetadataRecord>> getEmployeeStatuses() {

    List<MetadataRecord> employeeTypes = metadataService.getAllEmployeeStatuses();
    return ResponseEntity.ok(employeeTypes);
  }

  @GetMapping(value = EndpointConstants.EMPLOYEE_STATUSES_URI
      + EndpointConstants.ID_PATH_VARIABLE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MetadataRecord> getEmployeeStatusById(@PathVariable Integer id) {

    MetadataRecord employeeStatus = metadataService.getEmployeeStatusById(id);
    return (employeeStatus != null) ?
        ResponseEntity.ok(employeeStatus) : ResponseEntity.noContent().build();
  }

  @GetMapping(value = EndpointConstants.EMPLOYEE_TITLES_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<EmployeeTitleDto>> getEmployeeTitles() {

    List<EmployeeTitleDto> employeeTypes = metadataService.getAllEmployeeTitles();
    return ResponseEntity.ok(employeeTypes);
  }

  @GetMapping(value = EndpointConstants.EMPLOYEE_TITLES_URI
      + EndpointConstants.ID_PATH_VARIABLE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EmployeeTitleDto> getEmployeeTitleById(@PathVariable Integer id) {

    EmployeeTitleDto employeeTitle = metadataService.getEmployeeTitleById(id);
    return (employeeTitle != null) ?
        ResponseEntity.ok(employeeTitle) : ResponseEntity.noContent().build();
  }

  @GetMapping(value = EndpointConstants.EMPLOYEE_TYPES_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<MetadataRecord>> getEmployeeTypes() {

    List<MetadataRecord> employeeTypes = metadataService.getAllEmployeeTypes();
    return ResponseEntity.ok(employeeTypes);
  }

  @GetMapping(value = EndpointConstants.EMPLOYEE_TYPES_URI
      + EndpointConstants.ID_PATH_VARIABLE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MetadataRecord> getEmployeeTypeById(@PathVariable Integer id) {

    MetadataRecord employeeType = metadataService.getEmployeeTypeById(id);
    return (employeeType != null) ?
        ResponseEntity.ok(employeeType) : ResponseEntity.noContent().build();
  }
}