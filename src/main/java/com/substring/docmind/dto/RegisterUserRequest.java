package com.substring.docmind.dto;

import com.substring.docmind.entity.Role;

public record RegisterUserRequest(
        String username,
        String email,
        String password
) {
}
