package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.repos.UserRepository;
import com.web.MyCourseWeb.requests.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);

    }

    public User getOneUser(Long userID) {
        return userRepository.findById(userID).orElse(null);

    }

    public User updateOneUser(Long userID, User newUser) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setUserMail(newUser.getUserMail());
            foundUser.setUserPassword(newUser.getUserPassword());
            foundUser.setPurchaseOrSale(newUser.getPurchaseOrSale());
            foundUser.setUserRoleID(newUser.getUserRoleID());
            foundUser.setCourseIDofTheUser(newUser.getCourseIDofTheUser());

            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }


    public void deleteOneUser(Long userID) {
        userRepository.deleteById(userID);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
