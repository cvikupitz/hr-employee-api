package com.company.hr.controller.v1;

import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.dto.metadata.ComprehensiveMetadata;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.enums.ClientRole;
import com.company.hr.service.MetadataService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(EndpointConstants.METADATA_ROOT_URI)
public class MetadataController {

  private final MetadataService metadataService;

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ComprehensiveMetadata> getAllMetadata() {

    List<MetadataRecord> employeeStatuses = metadataService.getAllEmployeeStatuses();
    List<MetadataRecord> employeeTitles = metadataService.getAllEmployeeTitles();
    List<MetadataRecord> employeeTypes = metadataService.getAllEmployeeTypes();
    ComprehensiveMetadata response = ComprehensiveMetadata.builder()
        .employeeStatuses(employeeStatuses)
        .employeeTitles(employeeTitles)
        .employeeTypes(employeeTypes)
        .build();

    return ResponseEntity.ok(response);
  }
}