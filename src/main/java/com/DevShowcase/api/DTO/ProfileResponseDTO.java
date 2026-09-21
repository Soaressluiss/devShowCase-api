package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Profile;

public record ProfileResponseDTO(
        Long id,
        String name
) {
    public static ProfileResponseDTO fromEntity(Profile profile) {
        return new ProfileResponseDTO(profile.getId(), profile.getName());
    }
}