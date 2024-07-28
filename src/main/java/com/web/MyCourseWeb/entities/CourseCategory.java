package com.web.MyCourseWeb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "CourseCategory")
@Data
public class CourseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseCategoryID;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private CourseCategory parentCategory;

    private String courseCategoryName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }


    public Long getCourseCategoryID() {
        return courseCategoryID;
    }

    public void setCourseCategoryID(Long courseCategoryID) {
        this.courseCategoryID = courseCategoryID;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
