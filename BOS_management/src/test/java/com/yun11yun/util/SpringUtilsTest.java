package com.yun11yun.util;

import com.yun11yun.base.SpringTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

import static org.junit.Assert.*;

public class SpringUtilsTest extends SpringTestCase {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Test
    public void getApplicationContext() {
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        assertNotNull("The applicationContext should not be null", applicationContext);
    }

    @Test
    public void testAutowiredHibernateTemplate() {
        assertNotNull("The hibernateTemplate should not be null", hibernateTemplate);
    }
}