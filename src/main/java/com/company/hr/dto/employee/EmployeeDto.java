package com.company.hr.dto.employee;

import com.company.hr.dto.links.Links;
import com.company.hr.dto.metadata.MetadataRecord;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDto {

  private String id;
  private String socialSecurityNumber;
  private String firstName;
  private String middleName;
  private String lastName;
  private String dateOfBirth;
  private String gender;
  private String startDate;
  private String endDate;
  private Float salary;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String zipCode;
  private String primaryPhone;
  private String secondaryPhone;
  private String emailAddress;
  private MetadataRecord department;
  private MetadataRecord status;
  private MetadataRecord title;
  private MetadataRecord type;
  private Links _links;
}