package com.substring.docmind.dto;

public record LoginResponse(
        String accessToken,
        UserDto user
) {
}
