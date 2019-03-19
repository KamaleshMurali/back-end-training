/**
 * 
 */
package com.ofs.training.dao;

import org.springframework.stereotype.Repository;

import com.ofs.training.model.User;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Repository
public interface UserDao {

    public User getUser(long id);
}
