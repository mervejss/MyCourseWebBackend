package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.dtos.UserDTO;
import com.web.MyCourseWeb.entities.Role;
import com.web.MyCourseWeb.entities.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(
                user.getUserID(),
                user.getUserRoleID().getRoleID(),
                user.getUserFullName(),
                user.getUserName(),
                user.getUserMail(),
                user.getUserPassword(),
                user.getPurchaseOrSale().ordinal(),
                user.getCreatedAt()
        );
    }

    public static User toUser(UserDTO userDTO, Role role) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setUserID(userDTO.getUserID());
        user.setUserRoleID(role);  // Burada Role nesnesi verilmeli.
        user.setUserFullName(userDTO.getUserFullName());
        user.setUserName(userDTO.getUserName());
        user.setUserMail(userDTO.getUserMail());
        user.setUserPassword(userDTO.getUserPassword());
        user.setPurchaseOrSale(User.PurchaseOrSaleType.values()[userDTO.getPurchaseOrSale()]);
        user.setCreatedAt(userDTO.getCreatedAt());
        return user;
    }
}
