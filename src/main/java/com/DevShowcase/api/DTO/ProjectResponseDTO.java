package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Project;

public record ProjectResponseDTO(
        Long id,
        String name
) {

    public  static  ProjectResponseDTO fromEntity (Project project) {
         return  new ProjectResponseDTO(project.getId(), project.getName());
    }
}
