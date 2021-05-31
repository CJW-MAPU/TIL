package com.example.demo.controller;

import com.example.demo.model.dto.RoleResponseData;
import com.example.demo.model.dto.UserRequestData;
import com.example.demo.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity.HeadersBuilder<?> addRole(UserRequestData requestData) {
        roleService.addRole(requestData);
        return ResponseEntity.noContent();
    }

    @GetMapping("/{requestData}")
    public ResponseEntity<RoleResponseData> getRole(@PathVariable UserRequestData requestData) {
        return ResponseEntity.ok(roleService.getRole(requestData));
    }
}
