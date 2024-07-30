package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class PurchaseOrSaleDTO {

    private Long purchaseOrSaleID;
    private Long userID; // User tablosundaki userID
    private Long courseID; // Course tablosundaki courseID
    private Integer transactionType; // Enum değerini int olarak temsil eder
    private Integer status; // Enum değerini int olarak temsil eder
    private Integer paymentMethod; // Enum değerini int olarak temsil eder

    // Getter ve Setter'lar

    public Long getPurchaseOrSaleID() {
        return purchaseOrSaleID;
    }

    public void setPurchaseOrSaleID(Long purchaseOrSaleID) {
        this.purchaseOrSaleID = purchaseOrSaleID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
