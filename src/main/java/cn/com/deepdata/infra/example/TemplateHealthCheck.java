package cn.com.deepdata.infra.example;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by admin on 2016/2/26.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if(!saying.contains("TEST")) {
            return Result.unhealthy("template does not include a name");
        }
        return Result.healthy();
    }
}
