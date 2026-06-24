/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2025 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.model.ai.engine.copilot.dto;

import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;

import java.util.Map;

@SuppressWarnings("checkstyle:RecordComponentName")
public record CopilotSessionToken(String token, @Nullable Map<String, String> endpoints) {

    private static final String DEFAULT_API_BASE = "https://api.githubcopilot.com";

    /**
     * Returns the API base URL from the endpoints map, or the default if not present.
     */
    @NotNull
    public String getApiBaseUrl() {
        if (endpoints != null && endpoints.containsKey("api")) {
            return endpoints.get("api");
        }
        return DEFAULT_API_BASE;
    }
}
