package com.substring.docmind.dto;

import com.substring.docmind.entity.Role;

public record UserDto(
        Long id,
        String username,
        String email,
        Role role
) {
}
