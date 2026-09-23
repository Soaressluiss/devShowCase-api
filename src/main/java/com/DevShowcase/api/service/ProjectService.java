package com.DevShowcase.api.service;


import com.DevShowcase.api.DTO.ProjectRequestDTO;
import com.DevShowcase.api.DTO.ProjectResponseDTO;
import com.DevShowcase.api.entity.Profile;
import com.DevShowcase.api.entity.Project;
import com.DevShowcase.api.repository.ProfileRepository;
import com.DevShowcase.api.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;

    public ProjectService(ProjectRepository projectRepository, ProfileRepository profileRepository) {
        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
    }

    public List<ProjectResponseDTO> findAll() {
        List<Project> allProjects = this.projectRepository.findAll();

        return allProjects.stream()
                .map(project -> new ProjectResponseDTO(
                        project.getId(),
                        project.getName()
                ))
                .toList();
    }

    public ProjectResponseDTO create(ProjectRequestDTO dto) {

        Profile profile = profileRepository.findById(dto.profileId())
                .orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado"));

        Project project = new Project();
        project.setName(dto.name());
        project.setProfile(profile);

        Project createdProject = this.projectRepository.save(project);

        return ProjectResponseDTO.fromEntity(createdProject);

    }
}
