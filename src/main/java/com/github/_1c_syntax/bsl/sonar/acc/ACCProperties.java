/*
 * This file is a part of SonarQube 1C (BSL) Community Plugin.
 *
 * Copyright © 2018-2020
 * Alexey Sosnoviy <labotamy@gmail.com>, Nikita Gryzlov <nixel2007@gmail.com>
 *
 * SPDX-License-Identifier: LGPL-3.0-or-later
 *
 * SonarQube 1C (BSL) Community Plugin is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * SonarQube 1C (BSL) Community Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with SonarQube 1C (BSL) Community Plugin.
 */
package com.github._1c_syntax.bsl.sonar.acc;

import com.github._1c_syntax.bsl.languageserver.configuration.Language;
import lombok.experimental.UtilityClass;
import org.sonar.api.PropertyType;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class ACCProperties {

  private final String ACC_CATEGORY = "ACC";

  public final String CREATE_EXTERNAL_ISSUES = "sonar.bsl.acc.createExternalIssues";
  public final boolean CREATE_EXTERNAL_ISSUES_DEFAULT_VALUE = true;
  public final String ACC_RULES_PATH  = "sonar.bsl.acc.accRulesPaths";

  public List<PropertyDefinition> getProperties() {
    return Arrays.asList(
      PropertyDefinition.builder(CREATE_EXTERNAL_ISSUES)
        .name("Create external issues with acc sources")
        .description(
          "Create external issue if no active rule was found"
        )
        .defaultValue(Boolean.valueOf(CREATE_EXTERNAL_ISSUES_DEFAULT_VALUE).toString())
        .type(PropertyType.BOOLEAN)
        .options(Language.RU.getLanguageCode(), Language.EN.getLanguageCode())
        .category(ACC_CATEGORY)
        .onQualifiers(Qualifiers.APP, Qualifiers.PROJECT)
        .index(31)
        .build(),
      PropertyDefinition.builder(ACC_RULES_PATH)
        .name("BSL Language Server ACC rules path")
        .description(
          "Path (absolute or relative) to json file with ACC rules"
        )
        .defaultValue("")
        .type(PropertyType.STRING)
        .category(ACC_CATEGORY)
        .onQualifiers(Qualifiers.APP)
        .index(32)
        .build()
    );
  }
}
