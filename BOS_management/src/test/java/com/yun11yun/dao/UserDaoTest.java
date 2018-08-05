package com.yun11yun.dao;

import com.yun11yun.base.SpringTestCase;
import com.yun11yun.domain.User;
import com.yun11yun.util.SpringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest extends SpringTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void getAll() {
        List<User> list = userDao.getAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testAutowired() {
        assertNotNull(userDao);
        assertNotNull(userDao.getHibernateTemplate());
    }

    @Test
    public void testTheCountOfUserTable() {
        int count = userDao.count();
        assertTrue(count > 0);
    }
}