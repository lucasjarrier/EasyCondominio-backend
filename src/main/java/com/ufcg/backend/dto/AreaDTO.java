package com.ufcg.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufcg.backend.enums.OperatingTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;


@Getter
@Setter
public class AreaDTO {

    private String name;
    private String description;
    @Transient
    @JsonIgnore
    private MultipartFile photoArea;
    private OperatingTime operatingTime;
    private Integer tempoPorReserva;

}
