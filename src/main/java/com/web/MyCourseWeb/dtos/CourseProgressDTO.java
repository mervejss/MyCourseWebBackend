package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class CourseProgressDTO {

    private Long courseProgressID;
    private Long userID; // User entity'sindeki userID
    private Long courseID; // Add this line

    private long userProgressTime;
    private Date createdAt;
    private Date updatedAt;

    // Getter ve Setter'lar

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

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
