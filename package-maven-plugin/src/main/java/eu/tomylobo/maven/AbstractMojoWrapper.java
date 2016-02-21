package eu.tomylobo.maven;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.project.MavenProject;

public abstract class AbstractMojoWrapper {
    protected final PackageMojo packageMojo;
    protected final MavenProject mavenProject;
    protected final MavenSession mavenSession;
    protected final BuildPluginManager pluginManager;

    public AbstractMojoWrapper(PackageMojo packageMojo) {
        this.packageMojo = packageMojo;
        this.mavenProject = packageMojo.mavenProject;
        this.mavenSession = packageMojo.mavenSession;
        this.pluginManager = packageMojo.pluginManager;
    }
}
