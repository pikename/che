/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.api.installer.server.model.impl;

import org.eclipse.che.api.core.model.workspace.config.ServerConfig;
import org.eclipse.che.api.installer.shared.model.Installer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Anatoliy Bazko
 */
public class InstallerImpl implements Installer {
    private String                    id;
    private String                    name;
    private String                    version;
    private String                    description;
    private List<String>              dependencies;
    private Map<String, String>       properties;
    private String                    script;
    private Map<String, ServerConfig> servers;

    public InstallerImpl(String id,
                         String name,
                         String version,
                         String description,
                         List<String> dependencies,
                         Map<String, String> properties,
                         String script,
                         Map<String, ? extends ServerConfig> servers) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.description = description;
        this.dependencies = dependencies;
        this.properties = properties;
        this.script = script;
        if (servers != null) {
            this.servers = new HashMap<>(servers);
        }
    }

    public InstallerImpl(Installer installer) {
        this(installer.getId(),
             installer.getName(),
             installer.getVersion(),
             installer.getDescription(),
             installer.getDependencies(),
             installer.getProperties(),
             installer.getScript(),
             installer.getServers());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<String> getDependencies() {
        if (dependencies == null) {
            dependencies = new ArrayList<>();
        }
        return dependencies;
    }

    @Override
    public Map<String, String> getProperties() {
        if (properties == null) {
            properties = new HashMap<>();
        }
        return properties;
    }

    @Override
    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public Map<String, ? extends ServerConfig> getServers() {
        if (servers == null) {
            servers = new HashMap<>();
        }
        return servers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstallerImpl)) return false;
        InstallerImpl installer = (InstallerImpl)o;
        return Objects.equals(getId(), installer.getId()) &&
               Objects.equals(getName(), installer.getName()) &&
               Objects.equals(getVersion(), installer.getVersion()) &&
               Objects.equals(getDescription(), installer.getDescription()) &&
               Objects.equals(getDependencies(), installer.getDependencies()) &&
               Objects.equals(getProperties(), installer.getProperties()) &&
               Objects.equals(getScript(), installer.getScript()) &&
               Objects.equals(getServers(), installer.getServers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                            getName(),
                            getVersion(),
                            getDescription(),
                            getDependencies(),
                            getProperties(),
                            getScript(),
                            getServers());
    }

    @Override
    public String toString() {
        return "InstallerImpl{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", version='" + version + '\'' +
               ", description='" + description + '\'' +
               ", dependencies=" + dependencies +
               ", properties=" + properties +
               ", script='" + script + '\'' +
               ", servers=" + servers +
               '}';
    }
}
