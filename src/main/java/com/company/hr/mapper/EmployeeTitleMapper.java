package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.model.EmployeeTitle;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT)
public interface EmployeeTitleMapper {

  MetadataRecord mapEmployeeTitleModelToDto(EmployeeTitle employeeTitle);

  List<MetadataRecord> mapEmployeeTitleModelsToDto(List<EmployeeTitle> employeeTitles);
}