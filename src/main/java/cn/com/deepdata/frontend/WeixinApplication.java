package cn.com.deepdata.frontend;

import cn.com.deepdata.frontend.dao.HelloDAO;
import cn.com.deepdata.frontend.example.TemplateHealthCheck;
import cn.com.deepdata.frontend.resources.WeixinResource;
import cn.com.deepdata.frontend.resources.example.HelloWorldResource;
import cn.com.deepdata.frontend.service.WeiXinService;
import cn.com.deepdata.frontend.service.impl.WeixinServiceImpl;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class WeixinApplication extends Application<WeixinConfiguration> {

    public static void main(String[] args) throws Exception {
        new WeixinApplication().run(args);
    }

    @Override
    public String getName() {
        return "wenxin-backend";
    }

    @Override
    public void initialize(Bootstrap<WeixinConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    private final HibernateBundle<WeixinConfiguration> hibernateBundle = new ScanningHibernateBundle<WeixinConfiguration>("cn.com.deepdata.frontend.entity") {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(WeixinConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };


    @Override
    public void run(WeixinConfiguration configuration,
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
