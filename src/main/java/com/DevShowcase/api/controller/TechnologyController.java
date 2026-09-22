package com.DevShowcase.api.controller;


import com.DevShowcase.api.DTO.TechnologyResponseDTO;
import com.DevShowcase.api.DTO.TechnologyResquestDTO;
import com.DevShowcase.api.service.TechnologyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private  final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAllTechnologies (){
             List<TechnologyResponseDTO> technologies =  this.technologyService.findAll();

             return ResponseEntity.ok(technologies);
    }

    @PostMapping
    public  ResponseEntity<TechnologyResponseDTO> createTechnology (@RequestBody @Valid TechnologyResquestDTO requestDTO){
        TechnologyResponseDTO createdTechnology = technologyService.create(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTechnology);

    }
}
