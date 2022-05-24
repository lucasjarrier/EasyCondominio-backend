package com.ufcg.backend.controller;

import com.ufcg.backend.models.Reserva;
import com.ufcg.backend.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> salvarReserva(@RequestBody Reserva reserva) {
        return new ResponseEntity<>(reservaService.save(reserva), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodasReservas() {
        return new ResponseEntity<>(reservaService.getAllReservas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{idArea}")
    public ResponseEntity<List<Reserva>> listarTodasReservasByIdArea(@PathVariable Long idArea) {
        return new ResponseEntity<>(reservaService.getAllReservaByIrArea(idArea), HttpStatus.ACCEPTED);
    }
}
