package com.ufcg.backend.repositories;

import com.ufcg.backend.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(value = "select r.* from reserva r where r.id_area_comum = :idArea", nativeQuery = true)
    Set<Reserva> getAllReservaByIdArea(@Param("idArea") Long idArea);
}
