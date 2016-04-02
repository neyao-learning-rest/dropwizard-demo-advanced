package org.oursight.dropwizard.demo.dao;

import org.oursight.dropwizard.demo.entity.WarningLog;
import org.hibernate.SessionFactory;

public class WarningLogDAO extends CommonDAO<WarningLog> {

    public WarningLogDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
