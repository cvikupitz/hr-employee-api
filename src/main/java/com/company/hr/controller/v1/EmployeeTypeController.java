package com.company.hr.controller.v1;

import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.SpringDocConstants;
import com.company.hr.dto.error.BaseErrorResponse;
import com.company.hr.dto.error.InvalidRequestErrorResponse;
import com.company.hr.dto.error.ResourceNotFoundResponse;
import com.company.hr.dto.error.UnauthorizedRequestResponse;
import com.company.hr.dto.metadata.CollectiveMetadata;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.enums.ClientRole;
import com.company.hr.service.EmployeeTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(EndpointConstants.V1_ROOT_URI + EndpointConstants.EMPLOYEE_TYPES_ROOT_URI)
@Tag(name = SpringDocConstants.EMPLOYEE_TYPES_API_TAG)
public class EmployeeTypeController {

  private final EmployeeTypeService employeeTypeService;

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Retrieves all employee types.")
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
  public ResponseEntity<CollectiveMetadata> getAllEmployeeTypes() {

    List<MetadataRecord> employeeTypes = employeeTypeService.getAllEmployeeTypes();
    CollectiveMetadata response = CollectiveMetadata.builder()
        .employeeTypes(employeeTypes)
        .build();

    return response.isEmpty() ?
        ResponseEntity.noContent().build() :
        ResponseEntity.ok(response);
  }

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Retrieves an employee type by its ID.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MetadataRecord.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = MetadataRecord.class))
      })
  @ApiResponse(description = SpringDocConstants.HTTP_BAD_REQUEST_DESCRIPTION, responseCode = SpringDocConstants.HTTP_BAD_REQUEST,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InvalidRequestErrorResponse.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = InvalidRequestErrorResponse.class))
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
  @ApiResponse(description = SpringDocConstants.HTTP_NOT_FOUND_DESCRIPTION, responseCode = SpringDocConstants.HTTP_NOT_FOUND,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ResourceNotFoundResponse.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = ResourceNotFoundResponse.class))
      })
  public ResponseEntity<MetadataRecord> getEmployeeTypeById(
      @Parameter(
          description = "The ID of the employee type to search for.",
          in = ParameterIn.PATH,
          schema = @Schema(implementation = Integer.class)) @PathVariable Integer id) {

    MetadataRecord employeeType = employeeTypeService.getEmployeeTypeById(id);
    return ResponseEntity.ok(employeeType);
  }

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI + EndpointConstants.EMPLOYEES_ROOT_URI,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Retrieves a list of employees related to the specified employee type ID.")
  public ResponseEntity<String> getEmployeesUnderTypeById() {

    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
  }
}