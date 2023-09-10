package com.company.hr;

import com.company.hr.constants.ConstraintConstants;
import com.company.hr.model.Department;
import com.company.hr.model.Employee;
import com.company.hr.model.EmployeeStatus;
import com.company.hr.model.EmployeeTitle;
import com.company.hr.model.EmployeeType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.commons.lang3.RandomStringUtils;

public final class TestUtils {

  private static final String UPDATE_USER_ID = "JUnit";
  private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#.00");
  private static final String[] GENDERS = {"M", "F", "U"};

  private TestUtils() {
    // Private constructor to hide implicit public one
  }

  public static Department generateMockDepartment() {

    Random random = new SecureRandom();
    Faker faker = new Faker();
    Timestamp now = Timestamp.from(Instant.now());
    return Department.builder()
        .id(random.nextInt(22) + 301)
        .title(faker.company().industry())
        .updateUserId(UPDATE_USER_ID)
        .updateTs(now)
        .build();
  }

  public static EmployeeStatus generateMockEmployeeStatus() {

    Random random = new SecureRandom();
    Faker faker = new Faker();
    Timestamp now = Timestamp.from(Instant.now());
    return EmployeeStatus.builder()
        .id(random.nextInt(9) + 101)
        .title(faker.company().buzzword())
        .updateUserId(UPDATE_USER_ID)
        .updateTs(now)
        .build();
  }

  public static EmployeeTitle generateMockEmployeeTitle() {

    Random random = new SecureRandom();
    Faker faker = new Faker();
    Timestamp now = Timestamp.from(Instant.now());
    return EmployeeTitle.builder()
        .id(random.nextInt(73) + 401)
        .title(faker.company().profession())
        .updateUserId(UPDATE_USER_ID)
        .updateTs(now)
        .build();
  }

  public static EmployeeType generateMockEmployeeType() {

    Random random = new SecureRandom();
    Faker faker = new Faker();
    Timestamp now = Timestamp.from(Instant.now());
    return EmployeeType.builder()
        .id(random.nextInt(3) + 201)
        .title(faker.company().buzzword())
        .updateUserId(UPDATE_USER_ID)
        .updateTs(now)
        .build();
  }

  public static Employee generateMockEmployee() {

    Random random = new SecureRandom();
    Faker faker = new Faker();
    return  Employee.builder()
        .id(RandomStringUtils.random(ConstraintConstants.EMPLOYEE_ID_LENGTH, ConstraintConstants.EMPLOYEE_ID_CHARS))
        .socialSecurityNumber(faker.idNumber().ssnValid())
        .firstName(faker.name().firstName())
        .middleName(faker.name().suffix())
        .lastName(faker.name().lastName())
        .dateOfBirth(new Date(faker.date().birthday().getTime()))
        .gender(GENDERS[random.nextInt(GENDERS.length)])
        .startDate(new Date(faker.date().past(10_950, TimeUnit.DAYS).getTime()))
        .endDate(random.nextBoolean() ?
            new Date(faker.date().past(90, TimeUnit.DAYS).getTime()) : null)
        .salary(Float.valueOf(
            DECIMAL_FORMATTER.format(random.nextInt(2_000) + random.nextFloat())))
        .addressLine1(faker.address().streetAddress(false))
        .addressLine2(faker.address().secondaryAddress())
        .city(faker.address().city())
        .state(faker.address().stateAbbr())
        .zipCode(faker.address().zipCode())
        .primaryPhone(faker.numerify("##########"))
        .secondaryPhone(random.nextBoolean() ?
            faker.numerify("##########") : null)
        .emailAddress(faker.internet().emailAddress())
        .department(generateMockDepartment())
        .status(generateMockEmployeeStatus())
        .title(generateMockEmployeeTitle())
        .type(generateMockEmployeeType())
        .build();
  }

  public static String marshalObjectToJson(Object obj) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(obj);
  }

  public static <T> String marshalObjectToXml(Object obj, Class<T> clazz) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
    StringWriter sw = new StringWriter();
    jaxbContext.createMarshaller().marshal(obj, sw);
    return sw.toString();
  }
}