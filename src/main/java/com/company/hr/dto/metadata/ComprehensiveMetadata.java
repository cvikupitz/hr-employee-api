package com.company.hr.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "Metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComprehensiveMetadata {

  @XmlElementWrapper
  @XmlElement(name = "department")
  private List<MetadataRecord> departments;
  @XmlElementWrapper
  @XmlElement(name = "employeeStatus")
  private List<MetadataRecord> employeeStatuses;
  @XmlElementWrapper
  @XmlElement(name = "employeeTitle")
  private List<MetadataRecord> employeeTitles;
  @XmlElementWrapper
  @XmlElement(name = "employeeType")
  private List<MetadataRecord> employeeTypes;

  @JsonIgnore
  public boolean isEmpty() {
    return (departments == null || departments.isEmpty()) &&
        (employeeStatuses == null || employeeStatuses.isEmpty()) &&
        (employeeTitles == null || employeeTitles.isEmpty()) &&
        (employeeTypes == null || employeeTypes.isEmpty());
  }
}