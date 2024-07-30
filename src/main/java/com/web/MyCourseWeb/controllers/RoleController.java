package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.dtos.RoleDTO;
import com.web.MyCourseWeb.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<RoleDTO> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO newRoleDTO) {
        RoleDTO createdRole = roleService.saveOneRole(newRoleDTO);
        return ResponseEntity.ok(createdRole);
    }

    @GetMapping("/{roleID}")
    public ResponseEntity<RoleDTO> getOneRole(@PathVariable Long roleID) {
        RoleDTO roleDTO = roleService.getOneRole(roleID);
        return roleDTO != null ? ResponseEntity.ok(roleDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{roleID}")
    public ResponseEntity<RoleDTO> updateOneRole(@PathVariable Long roleID, @RequestBody RoleDTO newRoleDTO) {
        RoleDTO updatedRole = roleService.updateOneRole(roleID, newRoleDTO);
        return updatedRole != null ? ResponseEntity.ok(updatedRole) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{roleID}")
    public ResponseEntity<Void> deleteOneRole(@PathVariable Long roleID) {
        roleService.deleteOneRole(roleID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllRoles() {
        roleService.deleteAllRoles();
        return ResponseEntity.noContent().build();
    }
}
