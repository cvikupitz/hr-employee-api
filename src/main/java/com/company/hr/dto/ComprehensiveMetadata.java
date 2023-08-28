package com.company.hr.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ComprehensiveMetadata {

  private List<MetadataRecord> employeeStatuses;
  private List<EmployeeTitleDto> employeeTitles;
  private List<MetadataRecord> employeeTypes;
}