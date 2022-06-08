package com.ufcg.backend.models;

import com.ufcg.backend.enums.OperatingTime;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class AreaComum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    private byte[] photo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(unique = true)
    private Set<Reserva> reservedList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(unique = true)
    private Set<Reserva> solicitationList;

    @Column
    private Integer tempoPorReserva;

    @Column
    private OperatingTime operatingTime;

    public void cleanReservas() {
        this.reservedList.clear();
        this.solicitationList.clear();
    }
}
