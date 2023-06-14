package com.ufcg.backend.models;

import com.ufcg.backend.dto.AreaDTO;
import com.ufcg.backend.enums.OperatingTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
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

    public AreaComum() {
        // Construtor vazio necessário para a entidade do JPA
    }

    public void cleanReservas() {
        this.reservedList.clear();
        this.solicitationList.clear();
    }

    public AreaComum(AreaDTO areaDTO) {
        this.name = areaDTO.getName();
        this.description = areaDTO.getDescription();
        this.tempoPorReserva = areaDTO.getTempoPorReserva();
        this.operatingTime = areaDTO.getOperatingTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Set<Reserva> getReservedList() {
        return reservedList;
    }

    public void setReservedList(Set<Reserva> reservedList) {
        this.reservedList = reservedList;
    }

    public Set<Reserva> getSolicitationList() {
        return solicitationList;
    }

    public void setSolicitationList(Set<Reserva> solicitationList) {
        this.solicitationList = solicitationList;
    }

    public Integer getTempoPorReserva() {
        return tempoPorReserva;
    }

    public void setTempoPorReserva(Integer tempoPorReserva) {
        this.tempoPorReserva = tempoPorReserva;
    }

    public OperatingTime getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(OperatingTime operatingTime) {
        this.operatingTime = operatingTime;
    }
}