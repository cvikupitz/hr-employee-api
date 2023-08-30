package com.company.hr.dto.metadata;

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
  private List<MetadataRecord> employeeTitles;
  private List<MetadataRecord> employeeTypes;
}