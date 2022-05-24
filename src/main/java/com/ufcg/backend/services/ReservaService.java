package com.ufcg.backend.services;

import com.ufcg.backend.models.Reserva;
import com.ufcg.backend.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva save(Reserva r) {
        return reservaRepository.save(r);
    }

    public List<Reserva> getAllReservas() {
        return new ArrayList<>(reservaRepository.findAll());
    }

    public List<Reserva> getAllReservaByIrArea(Long id) {
        return new ArrayList<>(reservaRepository.getAllReservaByIdArea(id));
    }
}
