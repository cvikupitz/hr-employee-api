package com.company.hr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department extends MetadataModel implements Serializable  {

  private static final long serialVersionUID = -6386778502803665264L;
}