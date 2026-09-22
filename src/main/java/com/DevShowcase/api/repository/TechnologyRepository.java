package com.DevShowcase.api.repository;

import com.DevShowcase.api.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
