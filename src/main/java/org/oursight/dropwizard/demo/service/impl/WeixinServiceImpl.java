package org.oursight.dropwizard.demo.service.impl;

import org.oursight.dropwizard.demo.dao.RiskMesDAO;
import org.oursight.dropwizard.demo.dao.WarningHistoryDAO;
import org.oursight.dropwizard.demo.dao.WarningLogDAO;
import org.oursight.dropwizard.demo.service.WeiXinService;
import org.hibernate.SessionFactory;

/**
 * WeiXinService 的实现类
 * Created by neyao@github.com on 2016/4/1.
 */
public class WeixinServiceImpl implements WeiXinService {

    private WarningHistoryDAO warningHistoryDAO;

    private WarningLogDAO warningLogDAO;

    private RiskMesDAO riskMesDAO;

    public WeixinServiceImpl(SessionFactory sessionFactory) {
        warningHistoryDAO = new WarningHistoryDAO(sessionFactory);
        warningLogDAO = new WarningLogDAO(sessionFactory);
        riskMesDAO = new RiskMesDAO(sessionFactory);
    }

    @Override
    public WarningHistoryDAO getWarningHistoryDAO() {
        return warningHistoryDAO;
    }

    @Override
    public WarningLogDAO getWarningLogDAO() {
        return warningLogDAO;
    }

    @Override
    public RiskMesDAO getRiskMesDAO() {
        return riskMesDAO;
    }
}
