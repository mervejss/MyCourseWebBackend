package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CourseProgress")
@Data
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseProgressID;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID; // User tablosundaki userID ile ilişkilendirilmiş
    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    private Course courseID; // Add this line

    private long userProgressTime; // saat cinsinden kullanıcının ilerlediği

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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

    public Long getCourseProgressID() {
        return courseProgressID;
    }

    public void setCourseProgressID(Long courseProgressID) {
        this.courseProgressID = courseProgressID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public long getUserProgressTime() {
        return userProgressTime;
    }

    public void setUserProgressTime(long userProgressTime) {
        this.userProgressTime = userProgressTime;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }
}
