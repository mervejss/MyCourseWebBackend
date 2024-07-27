package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;

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

    private long userProgressTime; // saat cinsinden kullanıcının ilerlediği

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
}
