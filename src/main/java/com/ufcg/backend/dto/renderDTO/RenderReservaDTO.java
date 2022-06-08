package com.ufcg.backend.dto.renderDTO;

import com.ufcg.backend.models.Reserva;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RenderReservaDTO {

    private String userName;

    private String userApto;

    private String hrInicioReserva;

    private String hrFimReserva;

    private String dtReserva;

    private Long idUser;

    private Long idReserva;

    private Integer idArea;

    public RenderReservaDTO(Reserva reserva, RenderMoradorDTO user) {
        this.hrInicioReserva = reserva.getHrInicioReserva();
        this.hrFimReserva = reserva.getHrFimReserva();
        this.dtReserva = reserva.getDtReserva();
        this.userName = user.getName();
        this.userApto = user.getApartment();
        this.idUser = user.getId();
        this.idReserva = reserva.getId();
        this.idArea = reserva.getIdAreaComum();
    }
}
