package com.springboot.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.User;
import com.springboot.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Class UserController
 */
@Slf4j
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
   
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/create", method = RequestMethod.POST, params = { "email", "name" })
    @ResponseBody
    public String create(String email, String name) {
        try {

            User user = new User(email, name);
            logger.info("loggert yrsy");
            logger.debug("loggert yrsy");
            logger.error("loggert yrsy");
            System.out.println("this is a test");
            // userDao.create(user);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created!";
    }

   
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, params = { "id" })
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
        //    User user = new User(id);
            logger.info("loggert We are in deletion");
            logger.debug("loggert We are in deletion");
            logger.error("loggert We are in deletion");
            // userDao.delete(user);
            userRepository.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    
    @RequestMapping(value = "/get-by-email", method = RequestMethod.GET, params = { "email" })
    @ResponseBody
    public List<User> getByEmail(String email) {
        List<User> listOfUser = null;
        try {
            // User user = userDao.getByEmail(email);
            listOfUser = userRepository.findByEmail(email);

            // userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return null;
        }
        return listOfUser;
    }
    
    @RequestMapping(value = "/get-all-mail", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllEmail() {
        List<User> listOfUser = null;
        try {
            // User user = userDao.getByEmail(email);
            listOfUser = userRepository.findAll();

            // userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return null;
        }
        return listOfUser;
    }


   
    @RequestMapping(value = "/update", method = RequestMethod.PUT, params = { "id", "email", "name" })
    @ResponseBody
    public String updateName(long id, String email, String name) {
        try {
            // User user = userDao.getById(id);
            User user = userRepository.findById(id);
            user.setEmail(email);
            user.setName(name);
            // userDao.update(user);
            userRepository.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
    
    @GetMapping("/get-user-by-id/{id}")
    public User getUserById(@PathVariable long id) {
        log.debug("I am in DB Service for getUserByID");
        return userRepository.findById(id);
    }

}
