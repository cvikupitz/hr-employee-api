package com.company.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MetadataRecord {

  private Integer id;
  private String title;
  private String updateUserId;
  private String updateTs;
}