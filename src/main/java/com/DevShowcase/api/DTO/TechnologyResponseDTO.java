package com.DevShowcase.api.DTO;

import com.DevShowcase.api.entity.Technology;

public record TechnologyResponseDTO(
        Long id,
        String technology,
        String description
) {

    public  static  TechnologyResponseDTO fromEntity (Technology technology){
        return  new TechnologyResponseDTO(technology.getId(), technology.getTechnology(), technology.getDescription());

    }
}
