/**
 * 
 */
package com.ofs.training.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofs.training.dao.UserDaoImpl;
import com.ofs.training.model.User;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Service
public class UserServiceImpl implements UserService {


    private UserDaoImpl userDao = new UserDaoImpl();
    /* (non-Javadoc)
     * @see com.ofs.training.service.UserService#getUser()
     */
    @Override
    public User getUser(long id) {

        return userDao.getUser(id);
    }
    /* (non-Javadoc)
     * @see com.ofs.training.service.UserService#create(com.ofs.training.model.User)
     */
    @Override
    public User create(User user) {

        return userDao.create(user);
    }
    /* (non-Javadoc)
     * @see com.ofs.training.service.UserService#delete(long)
     */
    @Override
    public void delete(long id) {

        userDao.delete(id);
    }
    /* (non-Javadoc)
     * @see com.ofs.training.service.UserService#update(com.ofs.training.model.User)
     */
    @Override
    public User update(User user) {

        return userDao.update(user);
    }
    /* (non-Javadoc)
     * @see com.ofs.training.service.UserService#readAll()
     */
    @Override
    public List<User> readAll() {

        return userDao.readAll();
    }

}
