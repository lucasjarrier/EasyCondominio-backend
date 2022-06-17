package com.ufcg.backend.controller;

import com.ufcg.backend.dto.AreaDTO;
import com.ufcg.backend.enums.OperatingTime;
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
    public ResponseEntity<HttpStatus> salvarAreaComum(@RequestBody AreaDTO areaDTO) throws Exception {
        areaComumService.save(areaDTO);
        areaComumService.criarReservaAutomatica();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AreaComum>> getAllAreas() {
        return new ResponseEntity<>(areaComumService.getAllAreas(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAreaById(@PathVariable Long id) {
        areaComumService.deleteAreaById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
