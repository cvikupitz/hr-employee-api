package com.company.hr;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestScriptGeneration {

  public static void main(String[] args) {

    final int MAX_ENTRIES = 150;
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    final Faker faker = new Faker();
    final Random random = new Random();

    StringBuilder builder = new StringBuilder()
        .append("INSERT INTO employees(_ID, SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME, DATE_OF_BIRTH,"
        + "GENDER, START_DATE, END_DATE, SALARY, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, "
        + "ZIP_CODE, PRIMARY_PHONE, SECONDARY_PHONE, EMAIL_ADDRESS, DEPARTMENT_ID, STATUS_ID, "
        + "TITLE_ID, TYPE_ID, UPDATE_USER_ID, UPDATE_TS) VALUES \n");

    for (int i = 1; i <= MAX_ENTRIES; i++) {

      String ssn = faker.idNumber().ssnValid();
      Name name = faker.name();
      Date birthDate = faker.date().birthday();
      String gender = random.nextBoolean() ? "M" : "F";
      Date startDate = faker.date().past(10_950, TimeUnit.DAYS);
      Date endDate = random.nextBoolean() ? faker.date().past(30, TimeUnit.DAYS) : null;
      Float salary = ((random.nextInt(2_000) + random.nextFloat()) + 1e-2f);
      Address address = faker.address();
      String primaryPhone = faker.regexify("\\d{10}");
      String secondaryPhone = faker.regexify("\\d{10}");
      String email = name.username() + "@company.net";
      int departmentId = random.nextInt(25) + 301;
      int employeeStatusId = random.nextInt(9) + 101;
      int employeeTitleId = random.nextInt(6) + 401;
      int employeeType = random.nextInt(3) + 201;

      builder
          .append("(").append(i).append(",")
          .append("'").append(ssn).append("',")
          .append("'").append(name.firstName().replace("'", "''")).append("',")
          .append("'").append(name.suffix().replace("'", "''")).append("',")
          .append("'").append(name.lastName().replace("'", "''")).append("',")
          .append("'").append(dateFormat.format(birthDate)).append("',")
          .append("'").append(gender).append("',")
          .append("'").append(dateFormat.format(startDate)).append("',");
      if (endDate != null) {
        builder.append("'").append(dateFormat.format(endDate)).append("',");
      } else {
        builder.append("NULL,");
      }

      builder
          .append(salary).append(",")
          .append("'").append(address.streetAddress().replace("'", "''")).append("',")
          .append("'").append(address.buildingNumber().replace("'", "''")).append("',")
          .append("'").append(address.city().replace("'", "''")).append("',")
          .append("'").append(address.stateAbbr()).append("',")
          .append("'").append(address.zipCode()).append("',")
          .append("'").append(primaryPhone).append("',")
          .append("'").append(secondaryPhone).append("',")
          .append("'").append(email).append("',")
          .append(departmentId).append(",")
          .append(employeeStatusId).append(",")
          .append(employeeTitleId).append(",")
          .append(employeeType).append(",")
          .append("@UpdateUserId,@UpdateTs)");
      if (i != MAX_ENTRIES) {
        builder.append(",\n");
      } else {
        builder.append(";");
      }
    }

    System.out.println(builder);
  }
}