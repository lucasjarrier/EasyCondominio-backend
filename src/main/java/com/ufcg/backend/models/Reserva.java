package com.ufcg.backend.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer idAreaComum;

    @Column
    private Long idUser;

    @Column
    private String hrInicioReserva;

    @Column
    private String hrFimReserva;

    @Column
    private String dtReserva;

    @Column
    private String nameArea;

    public Reserva(Integer idAreaComum, Long idUser, String hrInicioReserva, String hrFimReserva, String nameArea) {
        this.idAreaComum = idAreaComum;
        this.idUser = idUser;
        this.hrInicioReserva = hrInicioReserva;
        this.hrFimReserva = hrFimReserva;
        this.nameArea = nameArea;

        /*
         * Salva o dia atual da reserva.
         */
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dtReserva = formatter.format(new Date());
    }

    public Reserva() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdAreaComum() {
        return idAreaComum;
    }

    public void setIdAreaComum(Integer idAreaComum) {
        this.idAreaComum = idAreaComum;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getHrInicioReserva() {
        return hrInicioReserva;
    }

    public void setHrInicioReserva(String hrInicioReserva) {
        this.hrInicioReserva = hrInicioReserva;
    }

    public String getHrFimReserva() {
        return hrFimReserva;
    }

    public void setHrFimReserva(String hrFimReserva) {
        this.hrFimReserva = hrFimReserva;
    }

    public String getDtReserva() {
        return dtReserva;
    }

    public void setDtReserva(String dtReserva) {
        this.dtReserva = dtReserva;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }
}