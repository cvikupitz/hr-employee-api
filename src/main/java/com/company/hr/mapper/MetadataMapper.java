package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.model.Department;
import com.company.hr.model.EmployeeStatus;
import com.company.hr.model.EmployeeTitle;
import com.company.hr.model.EmployeeType;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT)
public interface MetadataMapper {

  MetadataRecord mapDepartmentToDto(Department department);

  List<MetadataRecord> mapDepartmentModelsToDto(List<Department> departments);

  MetadataRecord mapEmployeeStatusToDto(EmployeeStatus employeeStatus);

  List<MetadataRecord> mapEmployeeStatusModelsToDto(List<EmployeeStatus> employeeStatuses);

  MetadataRecord mapEmployeeTitleModelToDto(EmployeeTitle employeeTitle);

  List<MetadataRecord> mapEmployeeTitleModelsToDto(List<EmployeeTitle> employeeTitles);

  MetadataRecord mapEmployeeTypeToDto(EmployeeType employeeType);

  List<MetadataRecord> mapEmployeeTypeModelsToDto(List<EmployeeType> employeeTypes);
}