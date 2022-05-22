package com.ufcg.backend.repositories;

import com.ufcg.backend.models.AreaComum;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@RepositoryRestResource
public interface  AreaComumRepository extends JpaRepository<AreaComum, Long> {

    Optional<AreaComum> findById(Long id);
}
