package com.DevShowcase.api.service;


import com.DevShowcase.api.DTO.TechnologyResponseDTO;
import com.DevShowcase.api.DTO.TechnologyResquestDTO;
import com.DevShowcase.api.entity.Technology;
import com.DevShowcase.api.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public List<TechnologyResponseDTO> findAll() {

        List<Technology> allTechnologies = this.technologyRepository.findAll();

        return allTechnologies.stream()
                .map(technology -> new TechnologyResponseDTO(
                        technology.getId(),
                        technology.getTechnology(),
                        technology.getDescription()
                ))
                .toList();
    }

    public TechnologyResponseDTO create(TechnologyResquestDTO dto) {
        Technology technology = dto.toEntity();
        var createdTechnology = this.technologyRepository.save(technology);

        return TechnologyResponseDTO.fromEntity(createdTechnology);

    }
}