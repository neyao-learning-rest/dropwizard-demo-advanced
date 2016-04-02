package org.oursight.dropwizard.demo.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 通用的DAO，供各个DAO继承
 * Created by neyao@github.com on 2016/3/30.
 */
public class CommonDAO<E> extends AbstractDAO<E> {

    private static final Logger logger = LoggerFactory.getLogger(CommonDAO.class);

    public CommonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public E saveOrUpdate(E entity) {
        return persist(entity);
    }

    public void save(E entity) {
        currentSession().save(entity);
    }

    public void update(E entity) {
        currentSession().update(entity);
    }

    public void batchSave(List<E> entities) {
        if(entities == null || entities.size() == 0) {
            logger.warn("entities is null or size is 0, will return directly");
            return;
        }

        for (E entity : entities) {
            currentSession().save(entity);
        }
    }

    public void batchUpdate(List<E> entities) {
        if(entities == null || entities.size() == 0) {
            logger.warn("entities is null or size is 0, will return directly");
            return;
        }

        for (E entity : entities) {
            currentSession().update(entity);
        }
    }

    public E findById(long id) {
        return get(id);
    }

}
