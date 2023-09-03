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
import org.springframework.util.CollectionUtils;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "Metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComprehensiveMetadata {

  @XmlElementWrapper
  @XmlElement(name = "employeeStatus")
  private List<MetadataRecord> employeeStatuses;
  @XmlElementWrapper
  @XmlElement(name = "employeeType")
  private List<MetadataRecord> employeeTypes;
  @XmlElementWrapper
  @XmlElement(name = "department")
  private List<MetadataRecord> departments;
  @XmlElementWrapper
  @XmlElement(name = "employeeTitle")
  private List<MetadataRecord> employeeTitles;

  @JsonIgnore
  public boolean isEmpty() {
    return
        CollectionUtils.isEmpty(departments) &&
        CollectionUtils.isEmpty(employeeStatuses) &&
        CollectionUtils.isEmpty(employeeTitles) &&
        CollectionUtils.isEmpty(employeeTypes);
  }
}