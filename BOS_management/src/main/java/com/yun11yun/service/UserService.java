package com.yun11yun.service;

import com.yun11yun.dao.UserDao;
import com.yun11yun.domain.User;
import freemarker.template.utility.NullArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void saveUser(User user) throws NullArgumentException {
        if (user == null) {
            throw new NullArgumentException();
        }
        userDao.saveUser(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
