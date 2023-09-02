package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.model.EmployeeStatus;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT)
public interface EmployeeStatusMapper {

  MetadataRecord mapEmployeeStatusToDto(EmployeeStatus employeeStatus);

  List<MetadataRecord> mapEmployeeStatusModelsToDto(List<EmployeeStatus> employeeStatuses);
}