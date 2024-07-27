package com.web.MyCourseWeb.controllers;

import com.web.MyCourseWeb.entities.Role;
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
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    public Role createRole(@RequestBody Role newRole) {
        return roleService.saveOneRole(newRole);
    }

    @GetMapping("/{roleID}")
    public ResponseEntity<Role> getOneRole(@PathVariable Long roleID) {
        Role role = roleService.getOneRole(roleID);
        return role != null ? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{roleID}")
    public ResponseEntity<Role> updateOneRole(@PathVariable Long roleID, @RequestBody Role newRole) {
        Role updatedRole = roleService.updateOneRole(roleID, newRole);
        return updatedRole != null ? ResponseEntity.ok(updatedRole) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{roleID}")
    public ResponseEntity<Void> deleteOneRole(@PathVariable Long roleID) {
        roleService.deleteOneRole(roleID);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAllRoles() {
        roleService.deleteAllRoles();
    }

}
