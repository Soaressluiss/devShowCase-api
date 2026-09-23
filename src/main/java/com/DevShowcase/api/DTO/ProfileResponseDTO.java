package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Profile;

import java.util.List;

public record ProfileResponseDTO(
        Long id,
        String name,
        List<ProjectResponseDTO> projects
) {
    public static ProfileResponseDTO fromEntity(Profile profile) {
        return new ProfileResponseDTO(
                profile.getId(),
                profile.getName(),
                profile.getProjects()
                .stream()
                .map(ProjectResponseDTO::fromEntity)
                .toList()
        );
    }
}