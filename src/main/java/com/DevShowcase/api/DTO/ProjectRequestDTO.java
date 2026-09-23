package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record ProjectRequestDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Length(
                min = 3,
                max = 20,
                message = "O nome do projeto deve ter entre 3 e 20 caracteres"
        )
        String name,

        @NotNull(message = "Id do perfil é obrigatório para cadastrar um projeto")
        Long profileId,

        @NotEmpty(message = "É necessário informar pelo menos uma tecnologia")
        List<@NotNull(message = "O id da tecnologia não pode ser nulo") Long> technologyIds

) {

    public Project toEntity() {
        Project project = new Project();
        project.setName(this.name);

        return project;
    }
}