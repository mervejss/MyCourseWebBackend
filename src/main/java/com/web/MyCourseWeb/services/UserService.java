package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.UserDTO;
import com.web.MyCourseWeb.entities.Role;
import com.web.MyCourseWeb.entities.User;
import com.web.MyCourseWeb.mappers.UserMapper;
import com.web.MyCourseWeb.repos.RoleRepository;
import com.web.MyCourseWeb.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO saveOneUser(UserDTO newUserDTO) {
        Role role = roleRepository.findById(newUserDTO.getUserRoleID()).orElse(null);
        if (role == null) {
            throw new IllegalArgumentException("Role not found with ID: " + newUserDTO.getUserRoleID());
        }
        User newUser = UserMapper.toUser(newUserDTO, role);
        User savedUser = userRepository.save(newUser);
        return UserMapper.toUserDTO(savedUser);
    }

    public UserDTO getOneUser(Long userID) {
        User user = userRepository.findById(userID).orElse(null);
        return UserMapper.toUserDTO(user);
    }

    public UserDTO updateOneUser(Long userID, UserDTO newUserDTO) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isPresent()) {
            Role role = roleRepository.findById(newUserDTO.getUserRoleID()).orElse(null);
            if (role == null) {
                throw new IllegalArgumentException("Role not found with ID: " + newUserDTO.getUserRoleID());
            }
            User foundUser = user.get();
            foundUser.setUserName(newUserDTO.getUserName());
            foundUser.setUserFullName(newUserDTO.getUserFullName());
            foundUser.setUserMail(newUserDTO.getUserMail());
            foundUser.setUserPassword(newUserDTO.getUserPassword());
            foundUser.setUserRoleID(role);
            User updatedUser = userRepository.save(foundUser);
            return UserMapper.toUserDTO(updatedUser);
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

    public UserDTO registerUser(UserDTO userDTO) {
        System.out.println("Registering user: " + userDTO);

        Role role = roleRepository.findById(userDTO.getUserRoleID())
                .orElseThrow(() -> new IllegalArgumentException("Role not found with ID: " + userDTO.getUserRoleID()));

        User user = UserMapper.toUser(userDTO, role);
        User savedUser = userRepository.save(user);

        System.out.println("User saved: " + savedUser);

        return UserMapper.toUserDTO(savedUser);
    }

    public UserDTO loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByUserMail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getUserPassword().equals(password)) {  // Şifre doğrulaması
                return UserMapper.toUserDTO(user);
            }
        }
        return null;
    }

}
