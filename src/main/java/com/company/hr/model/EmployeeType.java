package com.company.hr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_types")
public class EmployeeType extends MetadataModel implements Serializable {

}