package com.company.hr.controller.v1;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.service.MetadataService;
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
@RequestMapping(EndpointConstants.EMPLOYEE_TYPES_ROOT_URI)
public class EmployeeTypeController {

  private final MetadataService metadataService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<MetadataRecord>> getAllEmployeeTitles() {

    List<MetadataRecord> employeeTypes = metadataService.getAllEmployeeTypes();
    return ResponseEntity.ok(employeeTypes);
  }

  @GetMapping(value = EndpointConstants.ID_PATH_VARIABLE_URI, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<MetadataRecord> getEmployeeTitleById(@PathVariable Integer id) {

    MetadataRecord employeeType = metadataService.getEmployeeTitleById(id);
    return ResponseEntity.ok(employeeType);
  }
}