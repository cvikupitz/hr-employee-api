package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.employee.EmployeeSaveDto;
import com.company.hr.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT)
public interface EmployeeMapper {

  Employee mapEmployeeDtoToModel(EmployeeSaveDto saveDto);


}