package com.company.hr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class MetadataModel extends RootModel implements Serializable {

  @Id
  @Column(name = "_ID", nullable = false, updatable = false)
  private Integer id;
  @Column(name = "TITLE")
  private String title;
}