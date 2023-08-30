package com.company.hr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_statuses")
public class EmployeeStatus extends MetadataModel implements Serializable {

  private static final long serialVersionUID = -2971780109132043812L;
}