package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "PurchaseOrSale")
@Data
public class PurchaseOrSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrSaleID;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User user; // User tablosundaki userID ile ilişkilendirilmiş//BU KISIM postmanda long  olarak tutulacak

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    private Course courseID; // Course tablosundaki courseID ile ilişkilendirilmiş //BU KISIM postmanda long  olarak tutulacak


    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType; // İşlemin türü

    @Enumerated(EnumType.ORDINAL)
    private Status status; // İşlemin durumu

    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod; // Kullanıcının işlemi gerçekleştirmek için kullandığı ödeme yöntemi //BU KISIM postmanda  0,1,2,3,4 gibi int olarak tutulacak

    public enum TransactionType {
        PURCHASE, SALE
    }

    //COMPLETED=0, PENDING=1,CANCELED =2 gibi düşünebiliriz.//BU KISIM postmanda  0,1,2,3,4 gibi int olarak tutulacak
    public enum Status {
        COMPLETED, PENDING, CANCELED
    }

    public enum PaymentMethod { //BU KISIM postmanda  0,1,2,3,4 gibi int olarak tutulacak
        CREDIT_CARD,
        DEBIT_CARD,
        BANK_TRANSFER,
        PAYPAL,
        CRYPTOCURRENCY,
        MOBILE_PAYMENT,
        CASH_ON_DELIVERY,
        E_WALLET,
        PREPAID_CARD,
        CHECK,
        GIFT_CARD
    }


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getPurchaseOrSaleID() {
        return purchaseOrSaleID;
    }

    public void setPurchaseOrSaleID(Long purchaseOrSaleID) {
        this.purchaseOrSaleID = purchaseOrSaleID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
