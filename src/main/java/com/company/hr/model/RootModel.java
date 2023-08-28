package com.company.hr.model;

import com.company.hr.constants.ConstraintConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class RootModel implements Serializable {

  @Column(name = "UPDATE_USER_ID", nullable = false, length = ConstraintConstants.NAME_CHAR_LIMIT)
  private String updateUserId;
  @Column(name = "UPDATE_TS", nullable = false)
  private Timestamp updateTs;
}