package cn.com.deepdata.infra;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class WeixinConfiguration extends Configuration {

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
