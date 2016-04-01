package cn.com.deepdata.frontend.service.impl;

import cn.com.deepdata.frontend.dao.RiskMesDAO;
import cn.com.deepdata.frontend.dao.WarningHistoryDAO;
import cn.com.deepdata.frontend.dao.WarningLogDAO;
import cn.com.deepdata.frontend.service.WeiXinService;
import org.hibernate.SessionFactory;

/**
 * WeiXinService 的实现类
 * Created by neyao@github.com on 2016/4/1.
 */
public class WeixinServiceImpl implements WeiXinService {

    private SessionFactory sessionFactory;

    private WarningHistoryDAO warningHistoryDAO;

    private WarningLogDAO warningLogDAO;

    private RiskMesDAO riskMesDAO;

    public WeixinServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
