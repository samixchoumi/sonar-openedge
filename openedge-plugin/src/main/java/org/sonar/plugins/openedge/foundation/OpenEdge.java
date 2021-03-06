/*
 * OpenEdge plugin for SonarQube
 * Copyright (C) 2013-2016 Riverside Software
 * contact AT riverside DASH software DOT fr
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.openedge.foundation;

import java.util.List;

import org.sonar.api.config.Settings;
import org.sonar.api.resources.AbstractLanguage;
import org.sonar.plugins.openedge.api.Constants;
import org.sonar.plugins.openedge.api.com.google.common.base.Splitter;
import org.sonar.plugins.openedge.api.com.google.common.base.Strings;

public class OpenEdge extends AbstractLanguage {
  private static final String DEFAULT_FILE_SUFFIXES = "p,w,i,cls";

  private final Settings settings;

  public OpenEdge(Settings settings) {
    super(Constants.LANGUAGE_KEY, "OpenEdge");
    this.settings = settings;
  }

  @Override
  public String[] getFileSuffixes() {
    List<String> suffixes = Splitter.on(',').trimResults().omitEmptyStrings().splitToList(
        Strings.nullToEmpty(settings.getString(Constants.SUFFIXES)));
    if (suffixes.isEmpty()) {
      suffixes = Splitter.on(',').trimResults().omitEmptyStrings().splitToList(OpenEdge.DEFAULT_FILE_SUFFIXES);
    }
    return suffixes.toArray(new String[] {});
  }

}
