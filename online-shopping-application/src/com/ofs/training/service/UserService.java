/**
 * 
 */
package com.ofs.training.service;

import org.springframework.stereotype.Service;

import com.ofs.training.model.User;

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@Service
public interface UserService {

    public User getUser(long id);
}
