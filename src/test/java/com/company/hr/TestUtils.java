package com.company.hr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public final class TestUtils {

  private TestUtils() {
    // Private constructor to hide implicit public one
  }

  public String marshalObjectToJson(Object obj) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(obj);
  }

  public <T> String marshalObjectToXml(Object obj, Class<T> clazz) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
    StringWriter sw = new StringWriter();
    jaxbContext.createMarshaller().marshal(obj, sw);
    return sw.toString();
  }
}