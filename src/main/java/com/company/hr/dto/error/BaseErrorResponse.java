package com.company.hr.dto.error;

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
@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseErrorResponse {

  private String status;
  private int code;
  private String cause;
  private String suggestedAction;
  private String path;
  private String timestamp;
}