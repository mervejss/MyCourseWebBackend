package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.repos.UserRepository;
import com.web.MyCourseWeb.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
       return userService.saveOneUser(newUser);

    }

    @GetMapping("/{userID}")
    public User getOneUser(@PathVariable Long userID) {
        return userService.getOneUser(userID);
    }

    @PutMapping("/{userID}")
    public User updateOneUser(@PathVariable Long userID, @RequestBody User newUser) {
       return userService.updateOneUser(userID,newUser);
    }

    @DeleteMapping("/{userID}")
    public void deleteOneUser(@PathVariable Long userID) {
        userService.deleteOneUser(userID);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        userService.deleteAllUsers();
    }

}
