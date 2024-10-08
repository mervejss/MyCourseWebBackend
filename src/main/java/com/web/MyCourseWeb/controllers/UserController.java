package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.UserDTO;
import com.web.MyCourseWeb.dtos.UserWithRoleTypeDTO;
import com.web.MyCourseWeb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO newUserDTO) {
        try {
            UserDTO savedUser = userService.saveOneUser(newUserDTO);
            return ResponseEntity.ok(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getOneUser(@PathVariable Long userID) {
        UserDTO userDTO = userService.getOneUser(userID);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{userID}")
    public ResponseEntity<UserDTO> updateOneUser(@PathVariable Long userID, @RequestBody UserDTO newUserDTO) {
        try {
            UserDTO updatedUser = userService.updateOneUser(userID, newUserDTO);
            return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{userID}")
    public ResponseEntity<Void> deleteOneUser(@PathVariable Long userID) {
        userService.deleteOneUser(userID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllUsers() {
        userService.deleteAllUsers();
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO newUserDTO) {
        try {
            UserDTO registeredUser = userService.registerUser(newUserDTO);
            return ResponseEntity.ok(registeredUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestParam String email, @RequestParam String password) {
        UserDTO userDTO = userService.loginUser(email, password);
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(401).body(null);  // Unauthorized
        }
    }

    @GetMapping("/{userID}/profile")
    public ResponseEntity<UserWithRoleTypeDTO> getUserProfile(@PathVariable Long userID) {
        UserWithRoleTypeDTO userProfile = userService.getUserProfile(userID);
        return userProfile != null ? ResponseEntity.ok(userProfile) : ResponseEntity.notFound().build();
    }



}

