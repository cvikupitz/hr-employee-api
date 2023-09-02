package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.model.EmployeeType;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT)
public interface EmployeeTypeMapper {

  MetadataRecord mapEmployeeTypeToDto(EmployeeType employeeType);

  List<MetadataRecord> mapEmployeeTypeModelsToDto(List<EmployeeType> employeeTypes);
}