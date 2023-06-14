package com.ufcg.backend.dto;

import com.ufcg.backend.enums.OperatingTime;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;

public class AreaDTO {

    private String name;
    private String description;

    @Transient
    private MultipartFile photoArea;

    private OperatingTime operatingTime;
    private Integer tempoPorReserva;

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

    public MultipartFile getPhotoArea() {
        return photoArea;
    }

    public void setPhotoArea(MultipartFile photoArea) {
        this.photoArea = photoArea;
    }

    public OperatingTime getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(OperatingTime operatingTime) {
        this.operatingTime = operatingTime;
    }

    public Integer getTempoPorReserva() {
        return tempoPorReserva;
    }

    public void setTempoPorReserva(Integer tempoPorReserva) {
        this.tempoPorReserva = tempoPorReserva;
    }
}