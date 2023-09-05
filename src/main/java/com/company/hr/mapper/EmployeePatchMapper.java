package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.employee.EmployeeUpdateDto;
import com.company.hr.model.Employee;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    builder = @org.mapstruct.Builder(disableBuilder = true)
)
public abstract class EmployeePatchMapper {

  public abstract void patchEmployeeModel(@MappingTarget Employee employee, EmployeeUpdateDto updateDto);

  protected Date mapStringToDate(String value) {

    if (value.isEmpty()) {
      return null;
    }
    try {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
      return format.parse(value);
    } catch (ParseException e) {
      /* Should never happen as format validation happens at the controller layer */
      return null;
    }
  }

  protected <T> T unwrapOptional(Optional<T> value) {
    return value.orElse(null);
  }
}