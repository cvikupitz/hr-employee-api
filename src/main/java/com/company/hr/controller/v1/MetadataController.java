package com.company.hr.controller.v1;

import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.SpringDocConstants;
import com.company.hr.dto.error.BaseErrorResponse;
import com.company.hr.dto.error.UnauthorizedRequestResponse;
import com.company.hr.dto.metadata.CollectiveMetadata;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.enums.ClientRole;
import com.company.hr.service.DepartmentService;
import com.company.hr.service.EmployeeStatusService;
import com.company.hr.service.EmployeeTitleService;
import com.company.hr.service.EmployeeTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(EndpointConstants.V1_ROOT_URI + EndpointConstants.METADATA_ROOT_URI)
@Tag(name = SpringDocConstants.METADATA_API_TAG)
public class MetadataController {

  private final DepartmentService departmentService;
  private final EmployeeStatusService employeeStatusService;
  private final EmployeeTitleService employeeTitleService;
  private final EmployeeTypeService employeeTypeService;

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Retrieves all service metadata.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CollectiveMetadata.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = CollectiveMetadata.class))
      })
  @ApiResponse(description = SpringDocConstants.HTTP_NO_CONTENT_DESCRIPTION, responseCode = SpringDocConstants.HTTP_NO_CONTENT,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE)
      })
  @ApiResponse(description = SpringDocConstants.HTTP_UNAUTHORIZED_DESCRIPTION, responseCode = SpringDocConstants.HTTP_UNAUTHORIZED,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UnauthorizedRequestResponse.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = UnauthorizedRequestResponse.class))
      })
  @ApiResponse(description = SpringDocConstants.HTTP_FORBIDDEN_DESCRIPTION, responseCode = SpringDocConstants.HTTP_FORBIDDEN,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BaseErrorResponse.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = BaseErrorResponse.class))
      })
  public ResponseEntity<CollectiveMetadata> getAllMetadata() {

    List<MetadataRecord> departments = departmentService.getAllDepartments();
    List<MetadataRecord> employeeStatuses = employeeStatusService.getAllEmployeeStatuses();
    List<MetadataRecord> employeeTitles = employeeTitleService.getAllEmployeeTitles();
    List<MetadataRecord> employeeTypes = employeeTypeService.getAllEmployeeTypes();
    CollectiveMetadata response = CollectiveMetadata.builder()
        .departments(departments)
        .employeeStatuses(employeeStatuses)
        .employeeTitles(employeeTitles)
        .employeeTypes(employeeTypes)
        .build();

    return response.isEmpty() ?
        ResponseEntity.noContent().build() :
        ResponseEntity.ok(response);
  }
}