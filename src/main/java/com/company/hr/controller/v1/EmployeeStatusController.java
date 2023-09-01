package com.company.hr.controller.v1;

import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.enums.ClientRole;
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
@RequestMapping(EndpointConstants.EMPLOYEE_STATUSES_ROOT_URI)
public class EmployeeStatusController {

  private final MetadataService metadataService;

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<List<MetadataRecord>> getAllEmployeeStatuses() {

    List<MetadataRecord> employeeStatuses = metadataService.getAllEmployeeStatuses();
    return ResponseEntity.ok(employeeStatuses);
  }

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(value = EndpointConstants.ID_PATH_VARIABLE_URI, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<MetadataRecord> getEmployeeStatusById(@PathVariable Integer id) {

    MetadataRecord employeeStatus = metadataService.getEmployeeStatusById(id);
    return ResponseEntity.ok(employeeStatus);
  }
}