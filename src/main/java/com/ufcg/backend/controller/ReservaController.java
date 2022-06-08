package com.ufcg.backend.controller;

import com.ufcg.backend.dto.renderDTO.RenderReservaDTO;
import com.ufcg.backend.models.Reserva;
import com.ufcg.backend.security.CurrentUser;
import com.ufcg.backend.security.UserPrincipal;
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
    public ResponseEntity<List<RenderReservaDTO>> listarTodasReservasByIdArea(@PathVariable Long idArea) {
        return new ResponseEntity<>(reservaService.getAllReservaByIrArea(idArea), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{idReserva}")
    public ResponseEntity<HttpStatus> cancelarReservasById(@PathVariable Long idReserva) {
        try {
            reservaService.removeReservaFromId(idReserva);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/fazer-reserva/{idReserva}")
    public ResponseEntity<HttpStatus> fazerReservasById(@PathVariable Long idReserva, @CurrentUser UserPrincipal userPrincipal) {
        try {
            reservaService.fazerReservasById(idReserva, userPrincipal.getId());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
