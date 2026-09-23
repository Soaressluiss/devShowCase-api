package com.DevShowcase.api.service;

import com.DevShowcase.api.DTO.ProjectRequestDTO;
import com.DevShowcase.api.DTO.ProjectResponseDTO;
import com.DevShowcase.api.entity.Profile;
import com.DevShowcase.api.entity.Project;
import com.DevShowcase.api.entity.Technology;
import com.DevShowcase.api.repository.ProfileRepository;
import com.DevShowcase.api.repository.ProjectRepository;
import com.DevShowcase.api.repository.TechnologyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;
    private final TechnologyRepository technologyRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            ProfileRepository profileRepository,
            TechnologyRepository technologyRepository
    ) {
        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
        this.technologyRepository = technologyRepository;
    }

    public List<ProjectResponseDTO> findAll() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectResponseDTO::fromEntity)
                .toList();
    }

    public ProjectResponseDTO create(ProjectRequestDTO dto) {

        Profile profile = profileRepository.findById(dto.profileId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Perfil não encontrado")
                );

        List<Technology> technologies =
                technologyRepository.findAllById(dto.technologyIds());

        Project project = new Project();
        project.setName(dto.name());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project createdProject = projectRepository.save(project);

        return ProjectResponseDTO.fromEntity(createdProject);
    }
}