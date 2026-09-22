package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Project;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record ProjectRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        @Length(min = 3, max = 20, message = "O nome do projeto deve ter entre 3 e 20 caracteris")
        String name
) {
    public Project toEntity() {
        Project project = new Project();
        project.setName(this.name);

        return project;
    }
}
