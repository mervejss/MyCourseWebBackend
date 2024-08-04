package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class UserDTO {
    private Long userID;
    private Long userRoleID;  // Role entity yerine roleID olarak temsil edilir.
    private String userFullName;
    private String userName;
    private String userMail;
    private String userPassword;
    private Date createdAt;

    // Constructor
    public UserDTO() {}

    public UserDTO(Long userID, Long userRoleID, String userFullName, String userName,
                   String userMail, String userPassword, Date createdAt) {
        this.userID = userID;
        this.userRoleID = userRoleID;
        this.userFullName = userFullName;
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.createdAt = createdAt;
    }




    // Getters and Setters
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(Long userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
