/*
 * This file is a part of SonarQube 1C (BSL) Community Plugin.
 *
 * Copyright © 2018-2019
 * Nikita Gryzlov <nixel2007@gmail.com>
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
package com.github._1c_syntax.sonar.bsl;

import com.github._1c_syntax.sonar.bsl.language.BSLQualityProfile;
import org.junit.jupiter.api.Test;
import org.sonar.api.Plugin;
import org.sonar.api.SonarRuntime;
import org.sonar.api.internal.SonarRuntimeImpl;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.Version;

import static org.assertj.core.api.Assertions.assertThat;

public class BSLPluginTest {

    private static final Version VERSION_7_8 = Version.create(7, 8);
    private static final Version VERSION_7_9 = Version.create(7, 9);

    private BSLPlugin bslPlugin = new BSLPlugin();

    @Test
    public void sonarLint_7_8_extensions() {

        SonarRuntime runtime = SonarRuntimeImpl.forSonarLint(VERSION_7_8);
        Plugin.Context context = new Plugin.Context(runtime);
        bslPlugin.define(context);
        assertThat(context.getExtensions()).hasSize(8);

    }

    // TODO: а надо ли, вроде от версии 7.8?
    @Test
    public void sonarLint_7_9_extensions() {

        SonarRuntime runtime = SonarRuntimeImpl.forSonarLint(VERSION_7_9);
        Plugin.Context context = new Plugin.Context(runtime);
        bslPlugin.define(context);
        assertThat(context.getExtensions()).hasSize(8);

    }

    @Test
    public void test_qualityprofile() {
        BSLQualityProfile profile = new BSLQualityProfile();
        BuiltInQualityProfilesDefinition.Context context = new BuiltInQualityProfilesDefinition.Context();
        profile.define(context);
        // TODO: проверку
    }

}
