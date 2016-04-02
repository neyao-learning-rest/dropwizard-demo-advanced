package org.oursight.dropwizard.demo.resources.example;

import org.oursight.dropwizard.demo.dao.HelloDAO;
import org.oursight.dropwizard.demo.entity.User;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @SuppressWarnings("unused")
	private final AtomicLong counter;

    private HelloDAO helloDAO;


    public UserResource(HelloDAO helloDAO) {
        this.counter = new AtomicLong();
        this.helloDAO = helloDAO;
    }
    
    @GET
    @Timed
    @Path("/v1/list")
    @UnitOfWork
    public List<User> list(@QueryParam("name") Optional<String> name) {
        return helloDAO.list();
    }

}
