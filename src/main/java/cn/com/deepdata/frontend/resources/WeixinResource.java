package cn.com.deepdata.frontend.resources;

import cn.com.deepdata.frontend.entity.RiskMes;
import cn.com.deepdata.frontend.exception.ErrorMessage;
import cn.com.deepdata.frontend.service.WeiXinService;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/weixin")
@Produces(MediaType.APPLICATION_JSON)
public class WeixinResource {
    private static final Logger logger = LoggerFactory.getLogger(WeixinResource.class);

    private final AtomicLong counter;
    private WeiXinService weiXinService;

    public WeixinResource() {
        this.counter = new AtomicLong();
    }

    public void setWeiXinService(WeiXinService weiXinService) {
        this.weiXinService = weiXinService;
    }

    @GET
    @Timed
    @Path("/v1/list")
    @UnitOfWork
    public List<RiskMes> list(@QueryParam("name") Optional<String> name) {
        return weiXinService.getRiskMesDAO().list();
    }

    @GET
    @Timed
    @Path("/v1/get/{riskId}")
    @UnitOfWork
    public RiskMes list(@PathParam("riskId") LongParam riskId) {

        logger.debug("===================== riskId: {}", riskId);

        RiskMes riskMes = weiXinService.getRiskMesDAO().findById(riskId.get());
        if (riskMes == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND.getStatusCode())
                            .entity(ErrorMessage.RESULT_IS_EMPTY)
                            .build()
            );
        }

        return riskMes;

    }




//    /**
//     * 记录推送起了的信息
//     */
//    @POST
//    @Timed
//    @Path("/v1/riskmes")
//    @UnitOfWork
//    public RiskMes recordSentRisk(@Valid RiskMes message) {
//
//        logger.debug("WeixinSentMessage = " + message);
//        weiXinService.getRiskMesDAO().saveOrUpdate(message);
//        return message;
//
//
//    }



}
