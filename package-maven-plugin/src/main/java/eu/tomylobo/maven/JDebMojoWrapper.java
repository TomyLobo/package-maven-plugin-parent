package eu.tomylobo.maven;

import org.apache.maven.plugin.MojoExecutionException;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

public class JDebMojoWrapper extends AbstractMojoWrapper {

    public JDebMojoWrapper(PackageMojo packageMojo) {
        super(packageMojo);
    }

    public void execute() throws MojoExecutionException {
        executeMojo2(
                plugin(
                        groupId("org.vafer"),
                        artifactId("jdeb"),
                        version("1.5") // TODO: get version from <dependencies>
                ),
                goal("jdeb"),
                configuration(
                )
        );
    }
}
