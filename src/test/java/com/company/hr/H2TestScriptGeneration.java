package com.company.hr;

import com.company.hr.model.Employee;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class H2TestScriptGeneration {

  public static void main(String[] args) throws IOException {

    final int MAX_ENTRIES = 18_000;
    BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));
    writer.write("INSERT INTO employees(_ID, SSN, FIRST_NAME, MIDDLE_NAME, LAST_NAME, DATE_OF_BIRTH,"
        + "GENDER, START_DATE, END_DATE, SALARY, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, "
        + "ZIP_CODE, PRIMARY_PHONE, SECONDARY_PHONE, EMAIL_ADDRESS, DEPARTMENT_ID, STATUS_ID, "
        + "TITLE_ID, TYPE_ID, UPDATE_USER_ID, UPDATE_TS) VALUES \n");

    for (int i = 1; i <= MAX_ENTRIES; i++) {

      StringBuilder builder = new StringBuilder();
      Employee mockEmployee = TestUtils.generateMockEmployee();
      builder
          .append("('").append(mockEmployee.getId()).append("',")
          .append("'").append(mockEmployee.getSocialSecurityNumber()).append("',")
          .append("'").append(mockEmployee.getFirstName().replace("'", "''")).append("',")
          .append("'").append(mockEmployee.getMiddleName().replace("'", "''")).append("',")
          .append("'").append(mockEmployee.getLastName().replace("'", "''")).append("',")
          .append("'").append(mockEmployee.getDateOfBirth()).append("',")
          .append("'").append(mockEmployee.getGender()).append("',")
          .append("'").append(mockEmployee.getStartDate()).append("',");
      if (mockEmployee.getEndDate() != null) {
        builder.append("'").append(mockEmployee.getEndDate()).append("',");
      } else {
        builder.append("NULL,");
      }

      builder
          .append(mockEmployee.getSalary()).append(",")
          .append("'").append(mockEmployee.getAddressLine1().replace("'", "''")).append("',")
          .append("'").append(mockEmployee.getAddressLine2().replace("'", "''")).append("',")
          .append("'").append(mockEmployee.getCity().replace("'", "''")).append("',")
          .append("'").append(mockEmployee.getState()).append("',")
          .append("'").append(mockEmployee.getZipCode()).append("',")
          .append("'").append(mockEmployee.getPrimaryPhone()).append("',");
      if (mockEmployee.getSecondaryPhone() != null) {
        builder.append("'").append(mockEmployee.getSecondaryPhone()).append("',");
      } else {
        builder.append("NULL,");
      }
      builder
          .append("'").append(mockEmployee.getEmailAddress()).append("',")
          .append(mockEmployee.getDepartment().getId()).append(",")
          .append(mockEmployee.getStatus().getId()).append(",")
          .append(mockEmployee.getTitle().getId()).append(",")
          .append(mockEmployee.getType().getId()).append(",")
          .append("@UpdateUserId,@UpdateTs)");
      if (i != MAX_ENTRIES) {
        builder.append(",\n");
      } else {
        builder.append(";");
      }

      writer.write(builder.toString());
      System.out.printf("Wrote test record: %d / %d\n", i, MAX_ENTRIES);
    }

    writer.close();
  }
}