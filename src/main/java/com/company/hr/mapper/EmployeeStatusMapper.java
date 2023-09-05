package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.model.EmployeeStatus;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EmployeeStatusMapper {

  public abstract MetadataRecord mapEmployeeStatusToDto(EmployeeStatus employeeStatus);

  public abstract List<MetadataRecord> mapEmployeeStatusModelsToDto(List<EmployeeStatus> employeeStatuses);
}