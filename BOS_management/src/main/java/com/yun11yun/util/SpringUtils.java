package com.yun11yun.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class SpringUtils {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static<T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
}
