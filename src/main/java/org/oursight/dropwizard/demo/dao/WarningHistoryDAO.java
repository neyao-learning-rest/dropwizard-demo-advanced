package org.oursight.dropwizard.demo.dao;

import org.oursight.dropwizard.demo.entity.WarningHistory;
import org.hibernate.SessionFactory;

public class WarningHistoryDAO extends CommonDAO<WarningHistory> {

    public WarningHistoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
