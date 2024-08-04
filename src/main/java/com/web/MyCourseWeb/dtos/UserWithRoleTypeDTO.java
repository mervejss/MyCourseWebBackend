package com.web.MyCourseWeb.dtos;

import java.time.LocalDateTime;
import java.util.Date;

public class UserWithRoleTypeDTO {
    private Long userID;
    private String userFullName;
    private String userName;
    private String userMail;
    private String roleType;
    private LocalDateTime createdAt;

    public UserWithRoleTypeDTO(Long userID, String userFullName, String userName, String userMail, String roleType, Date createdAt) {
        this.userID = userID;
        this.userFullName = userFullName;
        this.userName = userName;
        this.userMail = userMail;
        this.roleType = roleType;
    }

    // Getters and Setters

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
