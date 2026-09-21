package com.DevShowcase.api.DTO;

public record ErrorResponse(
        int status,
        String message
) {
}
