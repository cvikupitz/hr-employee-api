package com.company.hr.mapper;

import com.company.hr.dto.EmployeeTitleDto;
import com.company.hr.dto.MetadataRecord;
import com.company.hr.model.EmployeeStatus;
import com.company.hr.model.EmployeeTitle;
import com.company.hr.model.EmployeeType;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetadataMapper {

  MetadataRecord mapEmployeeStatusToDto(EmployeeStatus employeeStatus);

  List<MetadataRecord> mapEmployeeStatusModelsToDto(List<EmployeeStatus> employeeStatuses);

  EmployeeTitleDto mapEmployeeTitleModelToDto(EmployeeTitle employeeTitle);

  List<EmployeeTitleDto> mapEmployeeTitleModelsToDto(List<EmployeeTitle> employeeTitles);

  MetadataRecord mapEmployeeTypeToDto(EmployeeType employeeType);

  List<MetadataRecord> mapEmployeeTypeModelsToDto(List<EmployeeType> employeeTypes);
}