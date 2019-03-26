package com.ofs.training.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@Controller
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
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{id}")
    private ResponseEntity<String> getUser(@PathVariable("id") Long id) {

        User user = userService.getUser(id);
        System.out.println(user.toString());
        ObjectMapper obj = new ObjectMapper();
        String result = null;
        try {
            result = obj.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/post")
    private ResponseEntity<String> create(@RequestBody User user) {

//        User userOne = new User();
//        userOne.setId(20l);
//        userOne.setFirstName("kamalesh");
//        userOne.setLastName("murali");
//        userOne.setEmail("kamalesh.murali@object-frontier.com");
//        userOne.setAddress("chennai");

        User createdUser = userService.create(user);
        ObjectMapper obj = new ObjectMapper();
        String result = null;
        try {
            result = obj.writeValueAsString(createdUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    private ResponseEntity<String> delete(@PathVariable("id") long id) {

        userService.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
    @PutMapping
    private ResponseEntity<String> update(@RequestBody User user) {

        User updatedUser = userService.update(user);
        ObjectMapper obj = new ObjectMapper();
        String result = null;
        try {
            result = obj.writeValueAsString(updatedUser);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/readAll")
    private ResponseEntity<String> readAll() {

        List<User> users = userService.readAll();
        ObjectMapper obj = new ObjectMapper();
        String result = null;
        try {
            result = obj.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
