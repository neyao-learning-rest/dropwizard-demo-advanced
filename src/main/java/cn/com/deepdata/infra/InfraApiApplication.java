package cn.com.deepdata.infra;

import cn.com.deepdata.infra.example.TemplateHealthCheck;
import cn.com.deepdata.infra.resources.example.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class InfraApiApplication extends Application<InfraApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new InfraApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "infra-api";
    }

    @Override
    public void initialize(Bootstrap<InfraApiConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(InfraApiConfiguration configuration,
                    Environment environment) throws Exception {

        System.out.println("configuration" + configuration);
        System.out.println("configuration getDefaultName" + configuration.getDefaultName());
        System.out.println("configuration getTemplate" + configuration.getTemplate());

        // TODO enable package scanning
        // https://github.com/HubSpot/dropwizard-guice/blob/master/README.md
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("tttt", healthCheck);
    }

}
