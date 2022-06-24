package com.ufcg.backend.repositories;

import com.ufcg.backend.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(value = "select r.* from reserva r where r.id_area_comum = :idArea order by r.hr_inicio_reserva asc", nativeQuery = true)
    List<Reserva> getAllReservaByIdArea(@Param("idArea") Long idArea);

    List<Reserva> findAllByIdUser(Long idUser);

    @Query(value = "delete from reserva r where r.id_area_comum = :idArea", nativeQuery = true)
    void deleteAllByIdArea(@Param("idArea") Long idArea);

    @Query(value = "delete from reserva r where r.id_user = :idUser", nativeQuery = true)
    void deleteAllByIdUser(@Param("idUser") Long idUser);

    @Query(value = "select count(*) from reserva r where r.id_user = :idUser", nativeQuery = true)
    Integer getTotalReservasByIdUser(@Param("idUser") Long idUser);
}
