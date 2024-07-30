package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class LogDTO {

    private Long logID;
    private Long userID; // User entity'sindeki userID
    private Integer logAction; // Enum değerini Integer olarak temsil eder
    private Date createdAt;

    // Getter ve Setter'lar

    public Long getLogID() {
        return logID;
    }

    public void setLogID(Long logID) {
        this.logID = logID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getLogAction() {
        return logAction;
    }

    public void setLogAction(Integer logAction) {
        this.logAction = logAction;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
