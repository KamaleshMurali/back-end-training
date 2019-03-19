/**
 * 
 */
package com.ofs.training.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ofs.training.model.User;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Repository
public interface UserDao {

    public User getUser(long id);
    public User create(User user);
    public void delete(long id);
    public User update(User user);
    public List<User> readAll();
}
