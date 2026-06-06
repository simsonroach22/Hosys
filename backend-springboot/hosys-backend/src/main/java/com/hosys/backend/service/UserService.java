package com.hosys.backend.service;

import com.hosys.backend.dto.UserResponse;
import com.hosys.backend.entity.User;
import com.hosys.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole().getRoleName())
                        .build())
                .toList();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}