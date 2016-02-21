package eu.tomylobo.maven;

import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.twdata.maven.mojoexecutor.MojoExecutor;

public abstract class AbstractMojoWrapper {
    protected final PackageMojo packageMojo;
    private final MojoExecutor.ExecutionEnvironment env;

    public AbstractMojoWrapper(PackageMojo packageMojo) {
        this.packageMojo = packageMojo;
        this.env = MojoExecutor.executionEnvironment(
                packageMojo.mavenProject,
                packageMojo.mavenSession,
                packageMojo.pluginManager
        );
    }

    protected void executeMojo2(Plugin plugin, String goal, Xpp3Dom configuration) throws MojoExecutionException {
        MojoExecutor.executeMojo(plugin, goal, configuration, env);
    }
}
