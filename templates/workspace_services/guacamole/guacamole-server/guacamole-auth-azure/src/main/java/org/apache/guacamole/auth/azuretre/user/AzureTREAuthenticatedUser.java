/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.guacamole.auth.azuretre.user;

import com.google.inject.Inject;
import org.apache.guacamole.net.auth.AbstractAuthenticatedUser;
import org.apache.guacamole.net.auth.AuthenticationProvider;
import org.apache.guacamole.net.auth.Credentials;

public class AzureTREAuthenticatedUser extends AbstractAuthenticatedUser {

    @Inject
    private AuthenticationProvider authProvider;

    private Credentials credentials;

    private String objectId;

    private String token;

    public void init(final Credentials credentials,
                     final String token,
                     final String username,
                     final String objectId) {
        this.credentials = credentials;
        this.token = token;
        this.objectId = objectId;
        setIdentifier(username.toLowerCase());
    }

    @Override
    public AuthenticationProvider getAuthenticationProvider() {
        return authProvider;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    public String getAccessToken() {
        return token;
    }
    public String getObjectId() {
        return objectId;
    }
}
