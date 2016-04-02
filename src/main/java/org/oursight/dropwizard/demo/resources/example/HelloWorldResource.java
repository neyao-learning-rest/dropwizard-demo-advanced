package org.oursight.dropwizard.demo.resources.example;

import org.oursight.dropwizard.demo.dao.HelloDAO;
import org.oursight.dropwizard.demo.entity.User;
import org.oursight.dropwizard.demo.exception.ErrorMessage;
import org.oursight.dropwizard.demo.exception.ErrorMessages;
import org.oursight.dropwizard.demo.pojo.Hello;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final AtomicLong counter;
    private final String template;
    private final String defaultName;
    private HelloDAO helloDAO;

    public HelloWorldResource(String template, String defaultName, HelloDAO helloDAO) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.helloDAO = helloDAO;
    }
    
    @GET
    @Timed
    @Path("/say")
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
            ErrorMessages errors = new ErrorMessages();
            errors.addError(ErrorMessage.PARAMETER_SHOULD_NOT_BE_NULL);
            errors.addError(ErrorMessage.RESULT_IS_EMPTY);

            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST).entity(errors).build()
                    );
        }

        return new Hello(counter.incrementAndGet(), value);
    }


    /**
     * 记录推送起了的信息
     */
    @POST
    @Timed
    @Path("/v1/user")
    @UnitOfWork
    public User addUser(@Valid User user) {

        helloDAO.saveOrUpdate(user);
        return user;


    }

    /**
     * 记录推送起了的信息
     */
    @POST
    @Timed
    @Path("/v1/users")
    @UnitOfWork
    public Response recordSentRisk(List<User> users) {

        System.out.println("Arrays.toString(users) = " + users);

        return Response.status(Response.Status.OK).build();


    }
}
