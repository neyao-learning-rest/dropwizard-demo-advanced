package cn.com.deepdata.frontend.resources.example;

import cn.com.deepdata.frontend.exception.ErrorMessage;
import cn.com.deepdata.frontend.pojo.Hello;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final AtomicLong counter;
    private final String template;
    private final String defaultName;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }
    
    @GET
    @Timed
    @Path("/v1/say")
    public Hello sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Hello(counter.incrementAndGet(), value);
    }

    @GET
    @Timed
    @Path("/v2/say")

    public Hello sayHello(@QueryParam("name") String name) {
        final String value = String.format(template, name);


        if (name == null) {
            throw new WebApplicationException(
                    Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
                            .entity(ErrorMessage.PARAMETER_SHOULD_NOT_BE_NULL)
                            .build()
            );
        }

        return new Hello(counter.incrementAndGet(), value);
    }
}
