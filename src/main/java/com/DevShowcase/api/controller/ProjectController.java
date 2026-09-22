package com.DevShowcase.api.controller;

import com.DevShowcase.api.DTO.ProjectRequestDTO;
import com.DevShowcase.api.DTO.ProjectResponseDTO;
import com.DevShowcase.api.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponseDTO> findAllProjects() {
        return projectService.findAll();
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody @Valid ProjectRequestDTO dto) {
        ProjectResponseDTO createdProject = projectService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdProject);
    }
}