package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.employee.EmployeeUpdateDto;
import com.company.hr.model.Employee;
import java.sql.Date;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    builder = @org.mapstruct.Builder(disableBuilder = true))
public abstract class EmployeePatchMapper {

  @Mapping(source = "departmentId", target = "department.id")
  @Mapping(source = "employeeStatusId", target = "status.id")
  @Mapping(source = "employeeTitleId", target = "title.id")
  @Mapping(source = "employeeTypeId", target = "type.id")
  public abstract void patchEmployeeModel(@MappingTarget Employee employee, EmployeeUpdateDto updateDto);

  protected Date mapStringToDate(String value) {

    if (StringUtils.isBlank(value)) {
      return null;
    }
    return Date.valueOf(value);
  }

  protected <T> T unwrapOptional(Optional<T> value) {
    return value.orElse(null);
  }
}