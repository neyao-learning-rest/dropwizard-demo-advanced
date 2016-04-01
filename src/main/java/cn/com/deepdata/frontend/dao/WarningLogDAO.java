package cn.com.deepdata.frontend.dao;

import cn.com.deepdata.frontend.entity.RiskMes;
import cn.com.deepdata.frontend.entity.WarningLog;
import org.hibernate.SessionFactory;

import java.util.List;

public class WarningLogDAO extends CommonDAO<WarningLog> {

    public WarningLogDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
