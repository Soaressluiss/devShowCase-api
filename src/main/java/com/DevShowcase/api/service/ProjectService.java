package com.DevShowcase.api.service;


import com.DevShowcase.api.DTO.ProjectRequestDTO;
import com.DevShowcase.api.DTO.ProjectResponseDTO;
import com.DevShowcase.api.entity.Project;
import com.DevShowcase.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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
        Project project = dto.toEntity();
        var createdProject = this.projectRepository.save(project);

        return ProjectResponseDTO.fromEntity(createdProject);

    }
}
