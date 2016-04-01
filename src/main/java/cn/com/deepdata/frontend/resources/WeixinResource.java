package cn.com.deepdata.frontend.resources;

import cn.com.deepdata.frontend.entity.RiskMes;
import cn.com.deepdata.frontend.entity.WarningHistory;
import cn.com.deepdata.frontend.entity.WarningLog;
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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/weixin/v1")
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
    @Path("/list")
    @UnitOfWork
    public List<RiskMes> list(@QueryParam("name") Optional<String> name) {
        return weiXinService.getRiskMesDAO().list();
    }

    @GET
    @Timed
    @Path("/get/{riskId}")
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

    /**
     * 记录微信推送历史
     */
    @POST
    @Timed
    @Path("/warning_history")
    @UnitOfWork
    public Response createWarningHistory(@Valid WarningHistory warningHistory) {

        logger.debug("warningHistory = " + warningHistory);
        weiXinService.getWarningHistoryDAO().save(warningHistory);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Timed
    @Path("/warning_histories")
    @UnitOfWork
    public Response batchCreateWarningHistory(@Valid List<WarningHistory> warningHistories) {

        logger.debug("warningHistory = " + warningHistories);
        weiXinService.getWarningHistoryDAO().batchSave(warningHistories);

        return Response.status(Response.Status.OK).build();
    }


    /**
     * 更新微信推送历史
     */
    @PUT
    @Timed
    @Path("/warning_history")
    @UnitOfWork
    public Response updateWarningHistory(@Valid WarningHistory warningHistory) {

        logger.debug("warningHistory = " + warningHistory);
        weiXinService.getWarningHistoryDAO().update(warningHistory);

        return Response.status(Response.Status.OK).build();


    }

    /**
     * 更新微信推送历史
     */
    @PUT
    @Timed
    @Path("/warning_histories")
    @UnitOfWork
    public Response batchUpdateWarningHistories(@Valid List<WarningHistory> warningHistories) {

        logger.debug("warningHistory = " + warningHistories);
        weiXinService.getWarningHistoryDAO().batchUpdate(warningHistories);

        return Response.status(Response.Status.OK).build();


    }

    /**
     * 记录微信推送日志
     */
    @POST
    @Timed
    @Path("/warning_log")
    @UnitOfWork
    public Response createWarningLog(@Valid WarningLog warningLog) {

        logger.debug("WarningLog = " + warningLog);
        weiXinService.getWarningLogDAO().save(warningLog);

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Timed
    @Path("/warning_logs")
    @UnitOfWork
    public Response batchCreateWarningLogs(@Valid List<WarningLog> warningLogs) {

        logger.debug("WarningLogs = " + warningLogs);
        weiXinService.getWarningLogDAO().batchSave(warningLogs);

        return Response.status(Response.Status.OK).build();
    }


}
