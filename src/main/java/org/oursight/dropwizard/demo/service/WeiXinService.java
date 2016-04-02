package org.oursight.dropwizard.demo.service;

import org.oursight.dropwizard.demo.dao.RiskMesDAO;
import org.oursight.dropwizard.demo.dao.WarningHistoryDAO;
import org.oursight.dropwizard.demo.dao.WarningLogDAO;

/**
 * 提供微信相关的所有服务
 * Created by neyao@github.com on 2016/3/31.
 */
public interface WeiXinService {

//    public void recordWeixinSentLog(WeixinSentMessage weixinSentMessage);

    WarningHistoryDAO getWarningHistoryDAO();

    WarningLogDAO getWarningLogDAO();

    RiskMesDAO getRiskMesDAO();

}
