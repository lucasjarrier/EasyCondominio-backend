package com.ufcg.backend.repositories;

import com.ufcg.backend.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
