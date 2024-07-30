package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class CourseProgressDTO {

    private Long courseProgressID;
    private Long userID; // User entity'sindeki userID
    private long userProgressTime;
    private Date createdAt;

    // Getter ve Setter'lar

    public Long getCourseProgressID() {
        return courseProgressID;
    }

    public void setCourseProgressID(Long courseProgressID) {
        this.courseProgressID = courseProgressID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public long getUserProgressTime() {
        return userProgressTime;
    }

    public void setUserProgressTime(long userProgressTime) {
        this.userProgressTime = userProgressTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
