package com.company.hr.mapper;

import com.company.hr.constants.ApplicationConstants;
import com.company.hr.dto.metadata.MetadataRecord;
import com.company.hr.model.Department;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ApplicationConstants.MAPSTRUCT_SPRING_COMPONENT,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DepartmentMapper {

  public abstract MetadataRecord mapDepartmentToDto(Department department);

  public abstract List<MetadataRecord> mapDepartmentModelsToDto(List<Department> departments);
}