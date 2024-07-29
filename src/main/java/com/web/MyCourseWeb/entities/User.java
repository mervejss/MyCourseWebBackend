package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @ManyToOne
    @JoinColumn(name = "userRoleID", referencedColumnName = "roleID")
    private Role userRoleID; // Role tablosundaki roleID ile ilişkilendirilmiş

    private String userFullName;



    private String userName;

    private String userMail;

    private String userPassword;

    /*@ManyToOne
    @JoinColumn(name = "courseIDofTheUser", referencedColumnName = "courseID")
    private Course CourseIDofTheUser; // Course tablosundaki courseID ile ilişkilendirilmiş

     */

    @Enumerated(EnumType.ORDINAL)
    private PurchaseOrSaleType purchaseOrSale; // Satın Alma veya Satış işlemi

    public enum PurchaseOrSaleType {
        PURCHASE, // Satın Alma
        SALE      // Satış
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Role getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(Role userRoleID) {
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

    public PurchaseOrSaleType getPurchaseOrSale() {
        return purchaseOrSale;
    }

    public void setPurchaseOrSale(PurchaseOrSaleType purchaseOrSale) {
        this.purchaseOrSale = purchaseOrSale;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
