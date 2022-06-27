package com.ufcg.backend.services;

import com.ufcg.backend.enums.OperatingTime;
import com.ufcg.backend.models.AreaComum;
import com.ufcg.backend.models.Reserva;
import com.ufcg.backend.repositories.AreaComumRepository;
import com.ufcg.backend.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AutoSistemService {

    @Autowired
    private AreaComumRepository areaComumRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Por hora o sistema so irá criar automaticamente reservas
     * com limite de reserva em 1h.
     */

    public void createReservasDiarias() {
        List<AreaComum> areaComumList = areaComumRepository.findAll();
        for (AreaComum areaComum : areaComumList) {
            if (areaComum.getReservedList() == null || areaComum.getReservedList().size() == 0) {
                Set<Reserva> reservList = new HashSet<>();
                areaComum.setReservedList(reservList);
                OperatingTime ot = areaComum.getOperatingTime();
                if (areaComum.getTempoPorReserva() == 1 || true) {
                    for (String i : areaComum.getOperatingTime().getReservas(ot)) {
                        Reserva reserva = new Reserva(Math.toIntExact(areaComum.getId()), 0L, i + ":00h", (Integer.parseInt(i) + 1) + ":00h", areaComum.getName());
                        areaComum.getReservedList().add(reserva);
                    }
                } else {
                    for (String i : areaComum.getOperatingTime().getReservas(ot)) {
                        Reserva reserva = new Reserva(Math.toIntExact(areaComum.getId()), 0L, i + ":00h", (Integer.parseInt(i) + 1) + ":00h", areaComum.getName());
                        Reserva reserva2 = new Reserva(Math.toIntExact(areaComum.getId()), 0L, i + ":30m", (Integer.parseInt(i) + 1) + ":00h", areaComum.getName());
                        areaComum.getReservedList().add(reserva);
                        areaComum.getReservedList().add(reserva2);
                    }
                }
                areaComumRepository.save(areaComum);
            }
        }
    }

    @Transactional
    public void cleanAllReservasList() {
        reservaRepository.deleteAll();
        List<AreaComum> areaComumList = areaComumRepository.findAll();
        for (AreaComum areaComum : areaComumList) {
            areaComum.cleanReservas();
            areaComumRepository.save(areaComum);
        }
    }
}
