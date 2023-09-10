package com.company.hr.controller.v1;

import com.company.hr.annotations.JwtAuthenticated;
import com.company.hr.constants.ApplicationConstants;
import com.company.hr.constants.ConstraintConstants;
import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.SpringDocConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.dto.employee.EmployeeUpdateDto;
import com.company.hr.dto.employee.UpsertResult;
import com.company.hr.dto.error.BaseErrorResponse;
import com.company.hr.dto.error.InvalidRequestErrorResponse;
import com.company.hr.dto.error.ResourceNotFoundResponse;
import com.company.hr.dto.error.UnauthorizedRequestResponse;
import com.company.hr.dto.result.ResultSet;
import com.company.hr.enums.ClientRole;
import com.company.hr.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(EndpointConstants.V1_ROOT_URI + EndpointConstants.EMPLOYEES_ROOT_URI)
@Tag(name = SpringDocConstants.EMPLOYEES_API_TAG)
public class EmployeeController {

  private final EmployeeService employeeService;

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Retrieves a page of employee records.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
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
  public ResponseEntity<ResultSet<EmployeeDto>> getEmployees(@RequestParam Map<String, String> requestParams) {

    ResultSet<EmployeeDto> resultSet = employeeService.getCollectionOfEmployees(requestParams);
    return resultSet.getCount() == 0 ?
        ResponseEntity.noContent().build() :
        ResponseEntity.ok(resultSet);
  }

  @JwtAuthenticated(ClientRole.READ_ONLY)
  @GetMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Retrieves an employee by their ID.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
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
  public ResponseEntity<EmployeeDto> getEmployeeById(
      @Parameter(
          required = true,
          description = "The ID of the employee to search for.",
          in = ParameterIn.PATH,
          schema = @Schema(implementation = String.class)) @PathVariable String id) {

    EmployeeDto employeeDto = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(employeeDto);
  }

  @JwtAuthenticated(ClientRole.USER)
  @PostMapping(
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Saves a new employee.")
  @ApiResponse(description = SpringDocConstants.HTTP_CREATED_DESCRIPTION, responseCode = SpringDocConstants.HTTP_CREATED,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
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
  public ResponseEntity<EmployeeDto> saveNewEmployee(
      @Parameter(
          required = true,
          name = ApplicationConstants.HEADER_CLIENT_KEY,
          description = "Name of the client making the request.",
          in = ParameterIn.HEADER,
          schema = @Schema(implementation = String.class)) @RequestHeader(name = ApplicationConstants.HEADER_CLIENT_KEY) String appName,
      @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true) @Valid @RequestBody EmployeeSaveDto request)
      throws URISyntaxException {

    EmployeeDto employee = employeeService.saveEmployee(appName, request);
    URI location = new URI(employee.get_links().getSelf().getHref());
    return ResponseEntity.created(location).body(employee);
  }

  @JwtAuthenticated(ClientRole.USER)
  @PutMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI,
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Replaces an employee record, or creates new employee if ID doesn't exist.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
      })
  @ApiResponse(description = SpringDocConstants.HTTP_CREATED_DESCRIPTION, responseCode = SpringDocConstants.HTTP_CREATED,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
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
  public ResponseEntity<EmployeeDto> replaceEmployeeById(
      @Parameter(
          required = true,
          name = ApplicationConstants.HEADER_CLIENT_KEY,
          description = "Name of the client making the request.",
          in = ParameterIn.HEADER,
          schema = @Schema(implementation = String.class)) @RequestHeader(name = ApplicationConstants.HEADER_CLIENT_KEY) String appName,
      @Parameter(
          description = "The ID of the employee to replace.",
          in = ParameterIn.PATH,
          schema = @Schema(implementation = String.class)) @PathVariable String id,
      @Valid @RequestBody EmployeeSaveDto request) throws URISyntaxException {

    if (!id.matches(ConstraintConstants.EMPLOYEE_ID_REGEX)) {
      throw new IllegalArgumentException("Employee ID must match the regex: " + ConstraintConstants.EMPLOYEE_ID_REGEX);
    }
    UpsertResult result = employeeService.upsertEmployee(id, appName, request);
    if (result.isCreated()) {
      URI location = new URI(result.getEmployeeDto().get_links().getSelf().getHref());
      return ResponseEntity.created(location).body(result.getEmployeeDto());
    } else {
      return ResponseEntity.ok(result.getEmployeeDto());
    }
  }

  @JwtAuthenticated(ClientRole.USER)
  @PatchMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI,
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Partially updates an employee record.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
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
  public ResponseEntity<EmployeeDto> updateEmployeeById(
      @Parameter(
          required = true,
          name = ApplicationConstants.HEADER_CLIENT_KEY,
          description = "Name of the client making the request.",
          in = ParameterIn.HEADER,
          schema = @Schema(implementation = String.class)) @RequestHeader(name = ApplicationConstants.HEADER_CLIENT_KEY) String appName,
      @Parameter(
          description = "The ID of the employee to update.",
          in = ParameterIn.PATH,
          schema = @Schema(implementation = String.class)) @PathVariable String id,
      @Valid @RequestBody EmployeeUpdateDto request) {

    if (request.isEmpty())
      throw new IllegalArgumentException("At least one update parameter must be provided in the request payload.");
    EmployeeDto employee = employeeService.patchEmployee(id, appName, request);
    return ResponseEntity.ok(employee);
  }

  @JwtAuthenticated(ClientRole.ADMINISTRATOR)
  @DeleteMapping(
      value = EndpointConstants.ID_PATH_VARIABLE_URI,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @Operation(summary = "Deletes an employee record.")
  @ApiResponse(description = SpringDocConstants.HTTP_OK_DESCRIPTION, responseCode = SpringDocConstants.HTTP_OK,
      content = {
          @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeDto.class)),
          @Content(mediaType = MediaType.APPLICATION_XML_VALUE, schema = @Schema(implementation = EmployeeDto.class))
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
  public ResponseEntity<EmployeeDto> deleteEmployeeById(
      @Parameter(
          description = "The ID of the employee to delete.",
          in = ParameterIn.PATH,
          schema = @Schema(implementation = String.class)) @PathVariable String id) {

    EmployeeDto employee = employeeService.deleteEmployee(id);
    return ResponseEntity.ok(employee);
  }

}