package com.company.hr.util;

import com.company.hr.constants.EndpointConstants;
import com.company.hr.dto.links.HRef;
import com.company.hr.dto.links.Links;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;

public class PageableUtils {

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
}