package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "Course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;


    @ManyToOne
    @JoinColumn(name = "courseCategoryID", referencedColumnName = "courseCategoryID")
    private CourseCategory courseCategoryID; // CourseCategory tablosundaki courseCategoryID ile ilişkilendirilmiş

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private User userID; // User tablosundaki userID ile ilişkilendirilmiş

    public CourseCategory getCourseCategoryID() {
        return courseCategoryID;
    }

    public void setCourseCategoryID(CourseCategory courseCategoryID) {
        this.courseCategoryID = courseCategoryID;
    }



    private String courseName;

    private String courseDescription;

    private Long courseTotalTime; // Yeni sütun

    private Long coursePrice;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Long getCourseTotalTime() {
        return courseTotalTime;
    }

    public void setCourseTotalTime(Long courseTotalTime) {
        this.courseTotalTime = courseTotalTime;
    }

    public Long getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Long coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
