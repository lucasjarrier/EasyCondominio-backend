package com.ufcg.backend.services;

import com.ufcg.backend.models.Announcement;
import com.ufcg.backend.repositories.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public void save(Announcement announcement) {
        Announcement a = new Announcement(announcement.getTitle(), announcement.getDescription(), announcement.getDtExpire(), announcement.getImportant(), announcement.getNotExpire());
        announcementRepository.save(a);
    }

    public List<Announcement> getAllAnnouncementByImportance() {
        return announcementRepository.findAllAnnouncementByImportant();
    }

    public List<Announcement> getAllAnnoucement() {
        return announcementRepository.findAll();
    }

    public List<Announcement> getAllAnnoucementFixeds() {
        return announcementRepository.findAllAnnouncementFixeds();
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllAnnouncement() {
        announcementRepository.deleteAll();
    }
}
