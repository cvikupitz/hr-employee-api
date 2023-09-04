package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.model.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT)
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

  protected Date mapStringToDate(String value) {

    if (StringUtils.isBlank(value)) {
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
}