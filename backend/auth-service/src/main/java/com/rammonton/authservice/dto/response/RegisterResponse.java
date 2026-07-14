package com.rammonton.authservice.dto.response;

import com.rammonton.authservice.entity.Role;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RegisterResponse {

    private Long id;

    private String email;

    private Role role;

    private LocalDateTime createdAt;
}