package com.ofs.training.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofs.training.model.User;
import com.ofs.training.service.UserService;

/**
 * 
 */

/**
 * @author kamalesh.murali
 * @since Mar 18, 2019
 */
@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    private ResponseEntity<String> getUsers() {

        User userOne = new User();
        userOne.setId(20l);
        userOne.setFirstName("kamalesh");
        userOne.setLastName("murali");
        userOne.setEmail("kamalesh.murali@object-frontier.com");
        userOne.setAddress("chennai");

        ObjectMapper obj = new ObjectMapper();
        String result = null;
        try {
            result = obj.writeValueAsString(userOne);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
    @GetMapping
    @RequestMapping("/{id}")
    private ResponseEntity<String> getUser(@PathVariable("id") Long id) {

        User user = userService.getUser(id);
        ObjectMapper obj = new ObjectMapper();
        String result = null;
        try {
            result = obj.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
