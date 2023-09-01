package com.company.hr.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvalidJsonResponse extends BaseErrorResponse {

  private String parseError;
  private Integer line;
  private Integer column;
  private Long byteOffset;
  private Long charOffset;
  private String offsetDesc;
  private String sourceDesc;
}