package cn.com.deepdata.frontend;

import cn.com.deepdata.frontend.dao.RiskMesDAO;
import cn.com.deepdata.frontend.example.TemplateHealthCheck;
import cn.com.deepdata.frontend.resources.example.HelloWorldResource;
import cn.com.deepdata.frontend.resources.WeixinResource;
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

//    private final HibernateBundle<WeixinConfiguration> hibernateBundle =
//            new HibernateBundle<WeixinConfiguration>(User.class) {
//                @Override
//                public DataSourceFactory getDataSourceFactory(WeixinConfiguration configuration) {
//                    return configuration.getDataSourceFactory();
//                }
//            };

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

        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(resource);

//        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());
//        final UserResource userResource = new UserResource(userDAO);
//        environment.jersey().register(userResource);

        final RiskMesDAO riskMesDAO = new RiskMesDAO(hibernateBundle.getSessionFactory());
        final WeixinResource weixinResource = new WeixinResource(riskMesDAO);
        environment.jersey().register(weixinResource);


        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("tttt", healthCheck);
    }

}
