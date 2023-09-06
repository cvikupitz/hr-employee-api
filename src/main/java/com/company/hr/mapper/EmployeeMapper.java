package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.dto.links.HRef;
import com.company.hr.dto.links.Links;
import com.company.hr.model.Employee;
import com.company.hr.service.EmployeeService;
import java.sql.Date;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    builder = @org.mapstruct.Builder(disableBuilder = true))
public abstract class EmployeeMapper {

  @Mapping(target = "dateOfBirth", dateFormat = "yyyy-MM-dd")
  @Mapping(target = "startDate", dateFormat = "yyyy-MM-dd")
  @Mapping(target = "endDate", dateFormat = "yyyy-MM-dd")
  public abstract EmployeeDto mapEmployeeModelToDto(Employee employee);

  @Mapping(source = "departmentId", target = "department.id")
  @Mapping(source = "employeeStatusId", target = "status.id")
  @Mapping(source = "employeeTitleId", target = "title.id")
  @Mapping(source = "employeeTypeId", target = "type.id")
  public abstract Employee mapEmployeeDtoToModel(EmployeeSaveDto employeeSaveDto);

  @AfterMapping
  public void afterMappingEmployeeModelToDto(@MappingTarget EmployeeDto employeeDto) {

    Links links = Links.builder()
        .self(HRef.builder()
            .href(EmployeeService.SELF_REF_ROOT_LINK + "/" + employeeDto.getId())
            .build())
        .build();
    employeeDto.set_links(links);
  }

  protected Date mapStringToDate(String value) {

    if (StringUtils.isBlank(value)) {
      return null;
    }
    return Date.valueOf(value);
  }
}