package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class CourseDTO {

    private Long courseID;
    private Long courseCategoryID;
    private Long userID;
    private String courseName;
    private String courseDescription;
    private Long courseTotalTime;
    private Long coursePrice;
    private Date createdAt;

    // Getters and Setters

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public Long getCourseCategoryID() {
        return courseCategoryID;
    }

    public void setCourseCategoryID(Long courseCategoryID) {
        this.courseCategoryID = courseCategoryID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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
