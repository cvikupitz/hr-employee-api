package com.company.hr.dto.metadata;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComprehensiveMetadata {

  @XmlElementWrapper
  @XmlElement(name = "employeeStatus")
  private List<MetadataRecord> employeeStatuses;
  @XmlElementWrapper
  @XmlElement(name = "employeeTitle")
  private List<MetadataRecord> employeeTitles;
  @XmlElementWrapper
  @XmlElement(name = "employeeType")
  private List<MetadataRecord> employeeTypes;
}