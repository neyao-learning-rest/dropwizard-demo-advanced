package cn.com.deepdata.frontend.dao;

import cn.com.deepdata.frontend.entity.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * HellowWorld Service
 * Created by neyao@github.com on 2016/3/30.
 */
public class HelloDAO extends CommonDAO<User> {

    public HelloDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<User> list() {
        return list(namedQuery("cn.com.deepdata.frontend.entity.User.findAll"));
    }

}
