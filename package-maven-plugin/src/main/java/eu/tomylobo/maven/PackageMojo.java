package eu.tomylobo.maven;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "package")
public class PackageMojo extends AbstractMojo {
    @Component
    public MavenProject mavenProject;

    @Component
    public MavenSession mavenSession;

    @Component
    public BuildPluginManager pluginManager;

    @Parameter
    public String classifier;

    @Parameter(defaultValue = "true")
    public String attach;

    public void execute() throws MojoExecutionException {
        JDebMojoWrapper mojoWrapper = new JDebMojoWrapper(this);
        mojoWrapper.execute();
    }
}
