package com.web.MyCourseWeb.dtos;

import java.util.Date;

public class CourseCategoryDTO {

    private Long courseCategoryID;
    private Long parentCategoryID; // Only the ID is needed for the DTO
    private String courseCategoryName;
    private Date createdAt;

    public Long getCourseCategoryID() {
        return courseCategoryID;
    }

    public void setCourseCategoryID(Long courseCategoryID) {
        this.courseCategoryID = courseCategoryID;
    }

    public Long getParentCategoryID() {
        return parentCategoryID;
    }

    public void setParentCategoryID(Long parentCategoryID) {
        this.parentCategoryID = parentCategoryID;
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
