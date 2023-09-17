package com.company.hr.util;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.QueryParamConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.links.HRef;
import com.company.hr.dto.links.Links;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public final class QueryParamUtils {

  private QueryParamUtils() {}

  public static <T> Links generateLinksWithMetadata(Page<T> page, String rootUri) {

    final String uri = rootUri + "?" + EndpointConstants.PAGE_QUERY_PARAM_NAME + "={page}&" +
        EndpointConstants.SIZE_QUERY_PARAM_NAME + "=" + page.getSize();

    final int currentPage = page.getNumber();
    final int totalPages = page.getTotalPages();
    final int prevPage = currentPage == 0 ? 0 : currentPage - 1;
    final int nextPage = currentPage == page.getTotalPages() - 1 ? currentPage : currentPage + 1;

    //FIXME If on last page, nullify last, and the rest..
    return Links.builder()
        .self(HRef.builder()
            .href(StringUtils.replace(uri, "{page}", Integer.toString(currentPage)))
            .build())
        .first(HRef.builder()
            .href(StringUtils.replace(uri, "{page}", Integer.toString(0)))
            .build())
        .last(HRef.builder()
            .href(StringUtils.replace(uri, "{page}", Integer.toString(totalPages - 1)))
            .build())
        .prev(HRef.builder()
            .href(StringUtils.replace(uri, "{page}", Integer.toString(prevPage)))
            .build())
        .next(HRef.builder()
            .href(StringUtils.replace(uri, "{page}", Integer.toString(nextPage)))
            .build())
        .build();
  }

  public static PageRequest getPageObjectFromQueryParams(Map<String, String> queryParams) {

    String pageValue =
        queryParams.getOrDefault(QueryParamConstants.PAGE_PARAM_NAME, Integer.toString(QueryParamConstants.DEFAULT_PAGE_PARAM));
    String sizeValue =
        queryParams.getOrDefault(QueryParamConstants.SIZE_PARAM_NAME, Integer.toString(QueryParamConstants.DEFAULT_SIZE_PARAM));

    int page = parseIntFromQuery(pageValue, 0, Integer.MAX_VALUE, QueryParamConstants.PAGE_PARAM_NAME);
    int size = parseIntFromQuery(sizeValue, 1, QueryParamConstants.DEFAULT_SIZE_PARAM, QueryParamConstants.SIZE_PARAM_NAME);
    return PageRequest.of(page, size);
  }

  private static int parseIntFromQuery(String value, int minAllowed, int maxAllowed, String paramName) {

    int result;

    try {
      result = Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid integer value supplied for parameter " +
          paramName + ", value '" + value + "' must be a valid integer.");
    }

    if (result < minAllowed || result > maxAllowed) {
      throw new IllegalArgumentException("Value out of range for parameter " + paramName +
          ", value '" + result + "' must be in the range: [" + minAllowed + ", " + maxAllowed + "].");
    }

    return result;
  }

  public static EmployeeDto filterRequiredFields(Map<String, String> queryParams, EmployeeDto source) {

    String fields = queryParams.getOrDefault(QueryParamConstants.FIELDS_PARAM_NAME, "");
    Set<String> requestedFields = new HashSet<>(Arrays.asList(fields.split(",")));
    if (requestedFields.isEmpty()) {
      return source;
    }

    return EmployeeDto.builder()
        .id(requestedFields.contains(QueryParamConstants.ID_PARAM_NAME) ? source.getId() : null)
        .socialSecurityNumber(requestedFields.contains(QueryParamConstants.SSN_PARAM_NAME) ? source.getSocialSecurityNumber() : null)
        .firstName(requestedFields.contains(QueryParamConstants.FIRST_NAME_PARAM_NAME) ? source.getFirstName() : null)
        .middleName(requestedFields.contains(QueryParamConstants.MIDDLE_NAME_PARAM_NAME) ? source.getMiddleName() : null)
        .lastName(requestedFields.contains(QueryParamConstants.LAST_NAME_PARAM_NAME) ? source.getLastName() : null)
        .dateOfBirth(requestedFields.contains(QueryParamConstants.DATE_OF_BIRTH_PARAM_NAME) ? source.getDateOfBirth() : null)
        .gender(requestedFields.contains(QueryParamConstants.GENDER_PARAM_NAME) ? source.getGender() : null)
        .startDate(requestedFields.contains(QueryParamConstants.START_DATE_PARAM_NAME) ? source.getStartDate() : null)
        .endDate(requestedFields.contains(QueryParamConstants.END_DATE_PARAM_NAME) ? source.getEndDate() : null)
        .salary(requestedFields.contains(QueryParamConstants.SALARY_PARAM_NAME) ? source.getSalary() : null)
        .addressLine1(requestedFields.contains(QueryParamConstants.ADDRESS_LINE_1_PARAM_NAME) ? source.getAddressLine1() : null)
        .addressLine2(requestedFields.contains(QueryParamConstants.ADDRESS_LINE_2_PARAM_NAME) ? source.getAddressLine2() : null)
        .city(requestedFields.contains(QueryParamConstants.CITY_PARAM_NAME) ? source.getCity() : null)
        .state(requestedFields.contains(QueryParamConstants.STATE_PARAM_NAME) ? source.getState() : null)
        .zipCode(requestedFields.contains(QueryParamConstants.ZIP_CODE_PARAM_NAME) ? source.getZipCode() : null)
        .primaryPhone(requestedFields.contains(QueryParamConstants.PRIMARY_PHONE_PARAM_NAME) ? source.getPrimaryPhone() : null)
        .secondaryPhone(requestedFields.contains(QueryParamConstants.SECONDARY_PHONE_PARAM_NAME) ? source.getSecondaryPhone() : null)
        .emailAddress(requestedFields.contains(QueryParamConstants.EMAIL_PARAM_NAME) ? source.getEmailAddress() : null)
        .department(requestedFields.contains(QueryParamConstants.DEPARTMENT_PARAM_NAME) ? source.getDepartment() : null)
        .status(requestedFields.contains(QueryParamConstants.STATUS_PARAM_NAME) ? source.getStatus() : null)
        .title(requestedFields.contains(QueryParamConstants.TITLE_PARAM_NAME) ? source.getTitle() : null)
        .type(requestedFields.contains(QueryParamConstants.TYPE_PARAM_NAME) ? source.getType() : null)
        ._links(source.get_links())
        .build();
  }

  /*
  firstName[=], default = "*"
  middleName[=], default = "*"
  lastName[=], default = "*"
  dateOfBirth[>,<,=,<=,>=], default = "*"
  gender[=], default="*"
  startDate[>,<,=,<=,>=], default = "*"
  endDate[>,<,=,<=,>=], default = "*"
  salary[>,<,=,<=,>=], default = "*"
  city[=], default="*"
  state[=], default="*"
  zipCode[=], default="*"
  department[=], default="*"
  status[=], default="*"
  title[=], default="*"
  type[=], default="*"
  */
}