package com.DevShowcase.api.DTO;
import com.DevShowcase.api.entity.Profile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfileRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
        String name
) {
    public Profile toEntity() {
        Profile profile = new Profile();
        profile.setName(this.name);
        return profile;
    }
}