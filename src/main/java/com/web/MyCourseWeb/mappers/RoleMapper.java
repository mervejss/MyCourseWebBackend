package com.web.MyCourseWeb.mappers;

import com.web.MyCourseWeb.entities.Role;
import com.web.MyCourseWeb.dtos.RoleDTO;

public class RoleMapper {

    public static RoleDTO toRoleDTO(Role role) {
        if (role == null) {
            return null;
        }
        return new RoleDTO(
                role.getRoleID(),
                role.getRoleType(),
                role.getCreatedAt()
        );
    }

    public static Role toRole(RoleDTO roleDTO) {
        if (roleDTO == null) {
            return null;
        }
        Role role = new Role();
        role.setRoleID(roleDTO.getRoleID());
        role.setRoleType(roleDTO.getRoleType());
        role.setCreatedAt(roleDTO.getCreatedAt());
        return role;
    }
}
