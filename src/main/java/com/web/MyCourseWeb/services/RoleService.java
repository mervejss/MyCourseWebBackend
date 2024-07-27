package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.entities.Role;
import com.web.MyCourseWeb.repos.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role saveOneRole(Role newRole) {
        return roleRepository.save(newRole);
    }

    public Role getOneRole(Long roleID) {
        return roleRepository.findById(roleID).orElse(null);
    }

    public Role updateOneRole(Long roleID, Role newRole) {
        Optional<Role> role = roleRepository.findById(roleID);
        if (role.isPresent()) {
            Role foundRole = role.get();
            foundRole.setRoleType(newRole.getRoleType()); // roleType güncellemesi
            roleRepository.save(foundRole);
            return foundRole;
        } else {
            return null;
        }
    }

    public void deleteOneRole(Long roleID) {
        roleRepository.deleteById(roleID);
    }

    public void deleteAllRoles() {
        roleRepository.deleteAll();
    }
}
