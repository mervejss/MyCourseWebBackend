package com.web.MyCourseWeb.dtos;

import java.time.LocalDateTime;
import java.util.Date;

public class UserWithRoleTypeDTO {
    private Long userID;
    private String userFullName;
    private String userName;
    private String userMail;
    private String userPassword;

    private String roleType;
    private Date createdAt;  // Bu alanın DTO'ya dahil olduğundan emin olun

    public UserWithRoleTypeDTO(Long userID, String userFullName, String userName, String userMail, String userPassword, String roleType, Date createdAt) {
        this.userID = userID;
        this.userFullName = userFullName;
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.roleType = roleType;
        this.createdAt = createdAt;

    }

    // Getters and Setters


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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
