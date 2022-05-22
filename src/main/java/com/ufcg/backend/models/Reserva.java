package com.ufcg.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer idAreaComum;

    @Column
    private Integer idUser;

    @Column
    private Date dataReserva;

    public Reserva(Integer idAreaComum, Integer idUser, Date dataReserva) {
        this.idAreaComum = idAreaComum;
        this.idUser = idUser;
        this.dataReserva = dataReserva;
    }
}
