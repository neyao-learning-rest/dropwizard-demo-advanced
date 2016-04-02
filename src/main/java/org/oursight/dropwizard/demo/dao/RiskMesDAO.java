package org.oursight.dropwizard.demo.dao;

import org.oursight.dropwizard.demo.entity.RiskMes;
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
        return list(namedQuery("RiskMes.findAll"));
    }



}
