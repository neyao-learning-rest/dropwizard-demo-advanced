package org.oursight.dropwizard.demo;

import org.oursight.dropwizard.demo.dao.HelloDAO;
import org.oursight.dropwizard.demo.example.TemplateHealthCheck;
import org.oursight.dropwizard.demo.resources.WeixinResource;
import org.oursight.dropwizard.demo.resources.example.HelloWorldResource;
import org.oursight.dropwizard.demo.service.WeiXinService;
import org.oursight.dropwizard.demo.service.impl.WeixinServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public String getName() {
        return "wenxin-backend";
    }

    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    private final HibernateBundle<MyConfiguration> hibernateBundle = new ScanningHibernateBundle<MyConfiguration>("org.oursight.dropwizard.demo") {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(MyConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };


    @Override
    public void run(MyConfiguration configuration,
                    Environment environment) throws Exception {

        System.out.println("configuration" + configuration);

        // init all services
        final WeiXinService weiXinService = new WeixinServiceImpl(hibernateBundle.getSessionFactory());

        // init all resources
        final WeixinResource weixinResource = new WeixinResource();
        weixinResource.setWeiXinService(weiXinService);
        environment.jersey().register(weixinResource);


        // init health check
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("tttt", healthCheck);

        // HelloWord example service
        final HelloDAO helloDAO = new HelloDAO(hibernateBundle.getSessionFactory());
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName(), helloDAO);
        environment.jersey().register(resource);

    }

}
