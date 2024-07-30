package com.web.MyCourseWeb.dtos;

import java.util.Date;
import com.web.MyCourseWeb.entities.Role.RoleType;

public class RoleDTO {
    private Long roleID;
    private RoleType roleType;
    private Date createdAt;

    // Constructor
    public RoleDTO() {}

    public RoleDTO(Long roleID, RoleType roleType, Date createdAt) {
        this.roleID = roleID;
        this.roleType = roleType;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
