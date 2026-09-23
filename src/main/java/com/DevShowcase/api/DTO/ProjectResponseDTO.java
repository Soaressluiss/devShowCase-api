package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Project;

import java.util.List;

public record ProjectResponseDTO(
        Long id,
        String name,
        List<TechnologyResponseDTO> technologies
) {

    public static ProjectResponseDTO fromEntity(Project project) {
        return new ProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getTechnologies()
                        .stream()
                        .map(TechnologyResponseDTO::fromEntity)
                        .toList()
        );
    }
}