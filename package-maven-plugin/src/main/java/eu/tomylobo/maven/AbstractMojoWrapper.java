package eu.tomylobo.maven;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginManagement;
import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.Xpp3DomUtils;
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
        PluginManagement pluginManagement = env.getMavenProject().getPluginManagement();
        Plugin pluginManagementPlugin = pluginManagement.getPluginsAsMap().get(plugin.getKey());

        configuration = Xpp3DomUtils.mergeXpp3Dom(configuration, (Xpp3Dom) pluginManagementPlugin.getConfiguration());
        MojoExecutor.executeMojo(plugin, goal, configuration, env);
    }
}
