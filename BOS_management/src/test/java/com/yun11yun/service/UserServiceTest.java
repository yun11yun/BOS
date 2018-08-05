package com.yun11yun.service;

import com.yun11yun.base.SpringTestCase;
import com.yun11yun.dao.UserDao;
import com.yun11yun.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest extends SpringTestCase {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Test
    public void testAutowired() {
        assertNotNull(userService);
        assertNotNull("The userService's Dao should be autowired", userService.getUserDao());
    }

    @Test
    public void getAll() {
        List<User> list = userService.getAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setFirstname("baibai");
        user.setLastname("zhi");
        user.setPhone("18987656789");
        user.setEmail("931431467@qq.com");

        int origin = userDao.count();
        userService.saveUser(user);

        int now = userDao.count();
        assertEquals(1,now - origin);
    }
}