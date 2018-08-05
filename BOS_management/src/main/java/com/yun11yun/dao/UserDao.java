package com.yun11yun.dao;

import com.yun11yun.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<User> getAll() {
        List<User> list = hibernateTemplate.loadAll(User.class);
        return list;
    }

    public void saveUser(User user) {
        hibernateTemplate.save(user);
    }

    public int count() {
        Long count = (Long)hibernateTemplate.find("select count(*) from User as user").listIterator().next();
        return count.intValue();
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
