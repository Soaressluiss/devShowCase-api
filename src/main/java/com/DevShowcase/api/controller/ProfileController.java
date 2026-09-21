package com.DevShowcase.api.controller;

import com.DevShowcase.api.DTO.ProfileRequestDTO;
import com.DevShowcase.api.DTO.ProfileResponseDTO;
import com.DevShowcase.api.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> createProfile(@RequestBody @Valid ProfileRequestDTO requestDTO) {
        ProfileResponseDTO createdProfile = profileService.create(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> getProfileById(@PathVariable Long id) {
        ProfileResponseDTO profile = profileService.findById(id);

        return ResponseEntity.ok(profile);

    }
}
