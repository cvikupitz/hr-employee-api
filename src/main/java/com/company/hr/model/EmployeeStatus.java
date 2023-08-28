package com.company.hr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_statuses")
public class EmployeeStatus extends MetadataModel implements Serializable {

}