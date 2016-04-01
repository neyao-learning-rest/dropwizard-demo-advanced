package cn.com.deepdata.frontend.dao;

import cn.com.deepdata.frontend.entity.RiskMes;
import cn.com.deepdata.frontend.entity.WarningHistory;
import org.hibernate.SessionFactory;

import java.util.List;

public class WarningHistoryDAO extends CommonDAO<WarningHistory> {

    public WarningHistoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
