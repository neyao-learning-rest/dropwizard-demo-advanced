package cn.com.deepdata.datacenter.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cn.com.deepdata.datacenter.api.Saying;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/weixin")
@Produces(MediaType.APPLICATION_JSON)
public class WeixinResource {
    private final AtomicLong counter;
    private final String template;
    private final String defaultName;

    public WeixinResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }
    
    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
