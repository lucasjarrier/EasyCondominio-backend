package com.ufcg.backend.services;

import com.ufcg.backend.dto.renderDTO.RenderMoradorDTO;
import com.ufcg.backend.dto.renderDTO.RenderReservaDTO;
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

    @Autowired
    private UserService userService;

    public Reserva save(Reserva r) {
        return reservaRepository.save(r);
    }

    public List<Reserva> getAllReservas() {
        return new ArrayList<>(reservaRepository.findAll());
    }

    public List<RenderReservaDTO> getAllReservaByIrArea(Long id) {
        List<RenderReservaDTO> reservaList = new ArrayList<>();
        for(Reserva reserva: reservaRepository.getAllReservaByIdArea(id)) {
            RenderMoradorDTO renderMoradorDTO = new RenderMoradorDTO();
            if(reserva.getIdUser() != 0) {
                renderMoradorDTO = userService.findById(reserva.getIdUser());
            }
            reservaList.add(new RenderReservaDTO(reserva, renderMoradorDTO));
        }
        return reservaList;
    }

    public void removeReservaFromId(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva != null) {
           reserva.setIdUser(0L);
           reservaRepository.save(reserva);
        }
    }

    public void fazerReservasById(Long idReserva, Long idUser) {
        Reserva reserva = reservaRepository.findById(idReserva).orElse(null);
        if (reserva != null) {
            reserva.setIdUser(idUser);
            reservaRepository.save(reserva);
        }
    }
}
