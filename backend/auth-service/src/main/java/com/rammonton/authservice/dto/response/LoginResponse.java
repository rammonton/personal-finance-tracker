package com.rammonton.authservice.dto.response;

import com.rammonton.authservice.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private Long id;

    private String email;

    private Role role;

    private String token;

}