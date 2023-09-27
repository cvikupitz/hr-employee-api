package com.company.hr.pojo;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.caseSensitive;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.constants.QueryParamConstants;
import com.company.hr.dto.employee.EmployeeDto;
import com.company.hr.dto.links.HRef;
import com.company.hr.dto.links.Links;
import com.company.hr.dto.links.Links.LinksBuilder;
import com.company.hr.model.Employee;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.util.UriUtils;

public final class QueryParamHandler {

  private final Map<String, String> QUERY_PARAMS;
  private final int PAGE;
  private final int SIZE;
  private final String URI;

  private static final String PAGE_PLACEHOLDER = "{page}";

  public QueryParamHandler(String uri, Map<String, String> queryParams) {

    StringBuilder uriBuilder = new StringBuilder()
        .append(uri)
        .append("?");
    Map<String, String> encodedQueryParams = UriUtils.encodeUriVariables(queryParams);
    for (Entry<String, String> entry : encodedQueryParams.entrySet()) {
      if (entry.getKey().equals(EndpointConstants.PAGE_QUERY_PARAM_NAME) ||
          entry.getKey().equals(EndpointConstants.SIZE_QUERY_PARAM_NAME)) {
        continue;
      }

      uriBuilder.append(entry.getKey())
          .append("=")
          .append(entry.getValue())
          .append("&");
    }

    String pageValue =
        queryParams.getOrDefault(QueryParamConstants.PAGE_PARAM_NAME, Integer.toString(QueryParamConstants.DEFAULT_PAGE_PARAM));
    String sizeValue =
        queryParams.getOrDefault(QueryParamConstants.SIZE_PARAM_NAME, Integer.toString(QueryParamConstants.DEFAULT_SIZE_PARAM));

    PAGE = parseIntFromQuery(pageValue, 0, Integer.MAX_VALUE, QueryParamConstants.PAGE_PARAM_NAME);
    SIZE = parseIntFromQuery(sizeValue, 1, QueryParamConstants.DEFAULT_SIZE_PARAM, QueryParamConstants.SIZE_PARAM_NAME);
    uriBuilder.append(EndpointConstants.SIZE_QUERY_PARAM_NAME)
        .append("=")
        .append(SIZE)
        .append("&")
        .append(EndpointConstants.PAGE_QUERY_PARAM_NAME)
        .append("=")
        .append(PAGE_PLACEHOLDER);
    URI = uriBuilder.toString();
    QUERY_PARAMS = queryParams;
  }

  public PageRequest getPageObject() {

    return PageRequest.of(PAGE, SIZE);
  }

  public List<EmployeeDto> filterRequiredEmployeeFields(List<EmployeeDto> source) {

    return source.stream()
        .map(this::filterRequiredFields)
        .collect(Collectors.toList());
  }

  public EmployeeDto filterRequiredEmployeeFields(EmployeeDto source) {

    return filterRequiredFields(source);
  }

  private int parseIntFromQuery(String value, int minAllowed, int maxAllowed, String paramName) {

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

  private EmployeeDto filterRequiredFields(EmployeeDto source) {

    String fields = QUERY_PARAMS.getOrDefault(QueryParamConstants.FIELDS_PARAM_NAME, "");
    if (StringUtils.isBlank(fields)) {
      return source;
    }
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

  public Example<Employee> getExampleObject() {

    /*
  public static final String DEPARTMENT_PARAM_NAME = "department";
  public static final String STATUS_PARAM_NAME = "status";
  public static final String TITLE_PARAM_NAME = "title";
  public static final String TYPE_PARAM_NAME = "type";
    */
    ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreNullValues()
        .withMatcher(QueryParamConstants.FIRST_NAME_PARAM_NAME, caseSensitive())
        .withMatcher(QueryParamConstants.MIDDLE_NAME_PARAM_NAME, caseSensitive())
        .withMatcher(QueryParamConstants.LAST_NAME_PARAM_NAME, caseSensitive())
        .withMatcher(QueryParamConstants.GENDER_PARAM_NAME, ignoreCase())
        .withMatcher(QueryParamConstants.CITY_PARAM_NAME, ignoreCase())
        .withMatcher(QueryParamConstants.STATE_PARAM_NAME, ignoreCase());

    Employee employee = Employee.builder()
        .socialSecurityNumber(QUERY_PARAMS.get(QueryParamConstants.SSN_PARAM_NAME))
        .firstName(QUERY_PARAMS.get(QueryParamConstants.FIRST_NAME_PARAM_NAME))
        .middleName(QUERY_PARAMS.get(QueryParamConstants.MIDDLE_NAME_PARAM_NAME))
        .lastName(QUERY_PARAMS.get(QueryParamConstants.LAST_NAME_PARAM_NAME))
        .gender(QUERY_PARAMS.get(QueryParamConstants.GENDER_PARAM_NAME))
        .city(QUERY_PARAMS.get(QueryParamConstants.CITY_PARAM_NAME))
        .state(QUERY_PARAMS.get(QueryParamConstants.STATE_PARAM_NAME))
        .zipCode(QUERY_PARAMS.get(QueryParamConstants.ZIP_CODE_PARAM_NAME))
        .startDate(QUERY_PARAMS.containsKey(QueryParamConstants.DATE_OF_BIRTH_PARAM_NAME) ?
            Date.valueOf(QUERY_PARAMS.get(QueryParamConstants.DATE_OF_BIRTH_PARAM_NAME)) : null)
        .startDate(QUERY_PARAMS.containsKey(QueryParamConstants.START_DATE_PARAM_NAME) ?
            Date.valueOf(QUERY_PARAMS.get(QueryParamConstants.START_DATE_PARAM_NAME)) : null)
        .endDate(QUERY_PARAMS.containsKey(QueryParamConstants.END_DATE_PARAM_NAME) ?
            Date.valueOf(QUERY_PARAMS.get(QueryParamConstants.END_DATE_PARAM_NAME)) : null)
        .build();
    return Example.of(employee, matcher);
  }

  public Links generateLinksWithMetadata(Page<?> page) {

    final int totalPages = page.getTotalPages();
    LinksBuilder<?, ?> linksBuilder = Links.builder()
        .self(HRef.builder()
            .href(StringUtils.replace(URI, PAGE_PLACEHOLDER, Integer.toString(PAGE)))
            .build());

    if (PAGE != 0) {
      final int prevPage = PAGE - 1;
      linksBuilder.prev(HRef.builder()
            .href(StringUtils.replace(URI, PAGE_PLACEHOLDER, Integer.toString(prevPage)))
            .build())
      .first(HRef.builder()
            .href(StringUtils.replace(URI, PAGE_PLACEHOLDER, Integer.toString(0)))
            .build());
    }

    if (PAGE != totalPages - 1) {
      linksBuilder.next(HRef.builder()
            .href(StringUtils.replace(URI, PAGE_PLACEHOLDER, Integer.toString(PAGE + 1)))
            .build())
      .last(HRef.builder()
            .href(StringUtils.replace(URI, PAGE_PLACEHOLDER, Integer.toString(totalPages - 1)))
            .build());
    }

    return linksBuilder.build();
  }
}