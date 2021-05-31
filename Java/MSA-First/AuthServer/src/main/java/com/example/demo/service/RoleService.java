package com.example.demo.service;

import com.example.demo.exception.AlreadyExistUsernameException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dto.RoleResponseData;
import com.example.demo.model.dto.UserRequestData;
import com.example.demo.model.entity.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(UserRequestData requestData) {
        String username = requestData.getUsername();

        Role role = Role.builder()
                .username(username)
                .role("ADMIN")
                .build();

        Optional<Role> check = roleRepository.findByUsername(username);

        if (check.isEmpty()) {
            roleRepository.save(role);
        } else {
            throw new AlreadyExistUsernameException();
        }
    }

    public RoleResponseData getRole(UserRequestData requestData) {
        String username = requestData.getUsername();

        Optional<Role> role = roleRepository.findByUsername(username);

        if (role.isPresent()) {
            return RoleResponseData.builder()
                    .role(role.get().getRole())
                    .build();
        } else {
            throw new UserNotFoundException();
        }
    }
}
