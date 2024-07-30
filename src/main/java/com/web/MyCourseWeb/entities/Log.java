package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name = "Logs")
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logID;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID; // User tablosundaki userID ile ilişkilendirilmiş

    @Enumerated(EnumType.ORDINAL)
    private LogAction LogAction; // LogAction durumu

    public enum LogAction {
        LOGIN,           // Giriş
        LOGOUT,          // Çıkış
        PURCHASE,        // Satın Alma
        SALE,            // Satış Yapma
        COURSE_PROGRESS  // Kurs İlerlemesi
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {

        createdAt = new Date();
    }

    public Long getLogID() {
        return logID;
    }

    public void setLogID(Long logID) {
        this.logID = logID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Log.LogAction getLogAction() {
        return LogAction;
    }

    public void setLogAction(Log.LogAction logAction) {
        LogAction = logAction;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
