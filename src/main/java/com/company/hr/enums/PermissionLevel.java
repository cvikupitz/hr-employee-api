package com.company.hr.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration for roles assigned to clients and their provided permission/access levels.
 *
 * @author Cole Vikupitz
 */
@RequiredArgsConstructor
@Getter
public enum PermissionLevel {

  /**
   * {@code READ_ONLY}<br>
   *
   * <p>Read-only access; users can view but perform no edits.</p>
   */
  READ_ONLY(Integer.MIN_VALUE),

  /**
   * {@code USER}<br>
   *
   * <p>User-level access; usually grants some (but not all) editing permissions.</p>
   */
  USER(0),

  /**
   * {@code ADMINISTRATOR}<br>
   *
   * <p>Admin-level access; all permissions granted.</p>
   */
  ADMINISTRATOR(Integer.MAX_VALUE);

  private final int level;
}