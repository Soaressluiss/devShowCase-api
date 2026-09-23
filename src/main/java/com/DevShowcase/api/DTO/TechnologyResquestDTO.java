package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Technology;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record TechnologyResquestDTO(
        @NotBlank(message = "Tecnologia é obrigátório")
        @Length(min = 3, max = 100, message = " deve ter entre 3 e 100 caracteres")
        String technology
) {

    public Technology toEntity() {
        Technology technology = new Technology();

        technology.setTechnology(this.technology);
        return technology;
    }
}
