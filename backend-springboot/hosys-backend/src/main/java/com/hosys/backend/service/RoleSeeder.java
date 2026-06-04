package com.hosys.backend.service;

import com.hosys.backend.entity.Role;
import com.hosys.backend.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {

        createRole("ADMIN");
        createRole("MANAGER");
        createRole("WAITER");
        createRole("CHEF");
    }

    private void createRole(String roleName) {

        if(roleRepository.findByRoleName(roleName).isEmpty()) {

            Role role = new Role();
            role.setRoleName(roleName);

            roleRepository.save(role);
        }
    }
}