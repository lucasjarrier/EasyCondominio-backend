package com.ufcg.backend.dto.renderDTO;

import com.ufcg.backend.models.Reserva;
import com.ufcg.backend.services.AreaComumService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

    private String nameArea;

    public RenderReservaDTO(Reserva reserva, RenderMoradorDTO user) {
        this.hrInicioReserva = reserva.getHrInicioReserva();
        this.hrFimReserva = reserva.getHrFimReserva();
        this.dtReserva = reserva.getDtReserva();
        this.userName = user.getName();
        this.userApto = user.getApartment();
        this.idUser = user.getId();
        this.idReserva = reserva.getId();
        this.idArea = reserva.getIdAreaComum();
        this.nameArea = reserva.getNameArea();
    }
}
