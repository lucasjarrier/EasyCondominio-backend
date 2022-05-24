package com.ufcg.backend.controller;

import com.ufcg.backend.models.AreaComum;
import com.ufcg.backend.services.AreaComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/area-comum")
public class AreaComumController {

    @Autowired
    private AreaComumService areaComumService;

    @PostMapping
    public ResponseEntity<AreaComum> salvarAreaComum(@RequestBody AreaComum areaComum) {
        return new ResponseEntity<>(areaComumService.save(areaComum), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AreaComum>> getAllAreas() {
        return new ResponseEntity<>(areaComumService.getAllAreas(), HttpStatus.ACCEPTED);
    }
}
