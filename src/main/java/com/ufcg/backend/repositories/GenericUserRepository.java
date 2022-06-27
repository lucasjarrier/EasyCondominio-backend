package com.ufcg.backend.repositories;

import com.ufcg.backend.models.GenericUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface GenericUserRepository extends JpaRepository<GenericUser, Long> {
    Optional<GenericUser> findById(long id);

    GenericUser findByLogin(String login);

    @Query(value = "select u.* from generic_user u where u.is_admin is not true", nativeQuery = true)
    List<GenericUser> findAllMoradores();
}

