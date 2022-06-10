package com.ufcg.backend.repositories;

import com.ufcg.backend.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query(value = "select a.* from announcement a order by a.id, a.important", nativeQuery = true)
    List<Announcement> findAllAnnouncementByImportant();

    @Query(value = "select a.* from announcement where a.not_expire is true order by a.id", nativeQuery = true)
    List<Announcement> findAllAnnouncementFixeds();
}
