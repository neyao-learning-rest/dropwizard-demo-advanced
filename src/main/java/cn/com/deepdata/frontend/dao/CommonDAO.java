package cn.com.deepdata.frontend.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

/**
 * Created by neyao@github.com on 2016/3/30.
 */
public class CommonDAO<E> extends AbstractDAO<E> {

    public CommonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public E saveOrUpdate(E entity) {
        return persist(entity);
    }

    public E findById(long id) {
        return get(id);
    }

}
