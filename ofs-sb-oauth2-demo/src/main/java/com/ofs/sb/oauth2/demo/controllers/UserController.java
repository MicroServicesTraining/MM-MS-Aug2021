/**
 * 
 */
package com.ofs.sb.oauth2.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofs.sb.oauth2.demo.model.User;
import com.ofs.sb.oauth2.demo.services.UserService;

/**
 * @author dorak
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @GetMapping
    public List<User> listUser(){
        return userServiceImpl.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public User findUser(@PathVariable Long id){
        return userServiceImpl.findUserById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userServiceImpl.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id){
        userServiceImpl.delete(id);
        return "success";
    }

}
