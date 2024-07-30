package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class UserDTO {
    private Long userID;
    private Long userRoleID;  // Role entity yerine roleID olarak temsil edilir.
    private String userFullName;
    private String userName;
    private String userMail;
    private String userPassword;
    private int purchaseOrSale;  // Enum yerine int olarak tutulur.
    private Date createdAt;

    // Constructor
    public UserDTO() {}

    public UserDTO(Long userID, Long userRoleID, String userFullName, String userName,
                   String userMail, String userPassword, int purchaseOrSale, Date createdAt) {
        this.userID = userID;
        this.userRoleID = userRoleID;
        this.userFullName = userFullName;
        this.userName = userName;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.purchaseOrSale = purchaseOrSale;
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

    public int getPurchaseOrSale() {
        return purchaseOrSale;
    }

    public void setPurchaseOrSale(int purchaseOrSale) {
        this.purchaseOrSale = purchaseOrSale;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
