package com.ufcg.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class AreaComum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private byte[] photo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(unique = true)
    private Set<Reserva> reservaList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(unique = true)
    private Set<Reserva> solicitationList;
}
