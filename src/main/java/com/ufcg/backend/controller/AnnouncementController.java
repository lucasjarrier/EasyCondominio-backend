package com.ufcg.backend.controller;

import com.ufcg.backend.models.Announcement;
import com.ufcg.backend.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<HttpStatus> createAnnouncement(@RequestBody Announcement announcement) {
        try {
            announcementService.save(announcement);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Announcement>> getAllAnnouncement() {
        return new ResponseEntity<>(announcementService.getAllAnnoucement(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllAnnouncement() {
        announcementService.deleteAllAnnouncement();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAnnouncementById(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
