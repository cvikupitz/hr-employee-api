package com.company.hr.dto.result;

import com.company.hr.dto.links.Links;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "Result")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultSet<T> {

  private List<T> results;
  private Links _links;
  private Integer count;
  private Long total;
}