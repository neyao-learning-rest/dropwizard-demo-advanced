package cn.com.deepdata.frontend.dao;

import cn.com.deepdata.frontend.entity.RiskMes;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by neyao@github.com on 2016/3/30.
 */
public class RiskMesDAO extends CommonDAO<RiskMes> {

    public RiskMesDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<RiskMes> list() {
        return list(namedQuery("cn.com.deepdata.frontend.entity.RiskMes.findAll"));
    }



}
