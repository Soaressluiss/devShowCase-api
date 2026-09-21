package com.DevShowcase.api.service;

import com.DevShowcase.api.DTO.ProfileRequestDTO;
import com.DevShowcase.api.DTO.ProfileResponseDTO;
import com.DevShowcase.api.entity.Profile;
import com.DevShowcase.api.repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

     private final  ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileResponseDTO findById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Perfil não encontrado com o ID: " + id));
        return ProfileResponseDTO.fromEntity(profile);
    }

    public ProfileResponseDTO create (ProfileRequestDTO dto) {
        Profile profile = dto.toEntity();
        Profile savedProfile = profileRepository.save(profile);
        return ProfileResponseDTO.fromEntity(savedProfile);
    }
}