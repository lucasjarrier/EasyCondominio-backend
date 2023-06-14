package com.ufcg.backend.dto.renderDTO;

import com.ufcg.backend.models.Reserva;

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

    public String getUserName() {
        return userName;
    }

    public String getUserApto() {
        return userApto;
    }

    public String getHrInicioReserva() {
        return hrInicioReserva;
    }

    public String getHrFimReserva() {
        return hrFimReserva;
    }

    public String getDtReserva() {
        return dtReserva;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public String getNameArea() {
        return nameArea;
    }
}