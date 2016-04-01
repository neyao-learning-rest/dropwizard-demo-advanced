package cn.com.deepdata.frontend.service;

import cn.com.deepdata.frontend.dao.RiskMesDAO;
import cn.com.deepdata.frontend.dao.WarningHistoryDAO;
import cn.com.deepdata.frontend.dao.WarningLogDAO;
import cn.com.deepdata.frontend.pojo.WeixinSentMessage;

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
