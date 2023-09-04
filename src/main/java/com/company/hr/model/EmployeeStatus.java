package com.company.hr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employee_statuses")
public class EmployeeStatus extends MetadataModel implements Serializable {

  private static final long serialVersionUID = -2971780109132043812L;
}