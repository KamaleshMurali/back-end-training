/**
 * 
 */
package com.ofs.training.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofs.training.dao.UserDao;
import com.ofs.training.model.User;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Service
public class UserServiceImpl implements UserService {

//    private UserDao userDao = new UserDao();
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User getUser(long id) {

        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public User create(User user) {

        return userDao.create(user);
    }

    @Override
    public void delete(long id) {

        userDao.delete(id);
    }

    @Override
    public User update(User user) {

        return userDao.update(user);
    }

    @Override
    public List<User> readAll() {

        return userDao.readAll();
    }

}
