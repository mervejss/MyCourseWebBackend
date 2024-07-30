package com.web.MyCourseWeb.services;

import com.web.MyCourseWeb.dtos.RoleDTO;
import com.web.MyCourseWeb.entities.Role;
import com.web.MyCourseWeb.mappers.RoleMapper;
import com.web.MyCourseWeb.repos.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(RoleMapper::toRoleDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO saveOneRole(RoleDTO newRoleDTO) {
        Role newRole = RoleMapper.toRole(newRoleDTO);
        Role savedRole = roleRepository.save(newRole);
        return RoleMapper.toRoleDTO(savedRole);
    }

    public RoleDTO getOneRole(Long roleID) {
        Role role = roleRepository.findById(roleID).orElse(null);
        return RoleMapper.toRoleDTO(role);
    }

    public RoleDTO updateOneRole(Long roleID, RoleDTO newRoleDTO) {
        Optional<Role> role = roleRepository.findById(roleID);
        if (role.isPresent()) {
            Role foundRole = role.get();
            foundRole.setRoleType(newRoleDTO.getRoleType());
            Role updatedRole = roleRepository.save(foundRole);
            return RoleMapper.toRoleDTO(updatedRole);
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
