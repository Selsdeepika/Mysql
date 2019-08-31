package com.springboot.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.domain.User;
import com.springboot.repository.UserRepository;

/**
 * Class UserController
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    // Wire the UserDao used inside this controller.
    /*
     * @Autowired private UserDao userDao;
     */

    @Autowired
    private UserRepository userRepository;

    /**
     * Create a new user with an auto-generated id and email and name as passed
     * values.
     */
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

    /**
     * Delete the user with the passed id.
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, params = { "id" })
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            // userDao.delete(user);
            userRepository.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * Retrieve the id for the user with the passed email address.
     */
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

    /**
     * Update the email and the name for the user indentified by the passed id.
     */
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

}
