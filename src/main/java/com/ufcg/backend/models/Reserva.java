package com.ufcg.backend.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
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

    public Reserva(Integer idAreaComum, Long idUser, String hrInicioReserva, String hrFimReserva) {
        this.idAreaComum = idAreaComum;
        this.idUser = idUser;
        this.hrInicioReserva = hrInicioReserva;
        this.hrFimReserva = hrFimReserva;
        /*
         * Salva o dia atual da reserva.
         */
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dtReserva = formatter.format(new Date());
    }
}
