package com.company.hr.controller.v1;

import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.SpringDocConstants;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.enums.ClientRole;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointConstants.V1_ROOT_URI + EndpointConstants.EMPLOYEES_ROOT_URI)
@Tag(name = SpringDocConstants.EMPLOYEES_API_TAG)
public class EmployeeController {

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @PostMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI,
      consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public ResponseEntity<String> testValidation(@Valid @RequestBody EmployeeSaveDto request) {

    return ResponseEntity.noContent().build();
  }
}