package com.ufcg.backend.repositories;

import com.ufcg.backend.models.GenericUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GenericUserRepository extends JpaRepository<GenericUser, Long> {
    Optional<GenericUser> findById(long id);

    GenericUser findByLogin(String login);
    
    @Query(value = "select gu.* from tb_generic_user gu where gu.id = :idUser and gu.is_club is false", nativeQuery = true)
    GenericUser findByIdUser(@Param("idUser") Long idUser);
}

