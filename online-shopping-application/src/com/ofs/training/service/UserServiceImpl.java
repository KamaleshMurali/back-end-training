/**
 * 
 */
package com.ofs.training.service;

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
        // TODO Auto-generated method stub
        return userDao.getUser(id);
    }

}
