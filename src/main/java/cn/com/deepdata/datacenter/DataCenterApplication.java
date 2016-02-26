package cn.com.deepdata.datacenter;

import cn.com.deepdata.datacenter.resources.WeixinResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DataCenterApplication extends Application<DataCenterConfiguration> {

    public static void main(String[] args) throws Exception {
        new DataCenterApplication().run(args);
    }

    @Override
    public String getName() {
        return "datacenter-api";
    }

    @Override
    public void initialize(Bootstrap<DataCenterConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DataCenterConfiguration configuration,
                    Environment environment) throws Exception {

        System.out.println("configuration" + configuration);
        System.out.println("configuration getDefaultName" + configuration.getDefaultName());
        System.out.println("configuration getTemplate" + configuration.getTemplate());

        final WeixinResource resource = new WeixinResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

    }

}
