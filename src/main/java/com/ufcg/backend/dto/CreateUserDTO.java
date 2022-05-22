package com.ufcg.backend.dto;

import com.ufcg.backend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserDTO {
    // COMMON INFO
    private String login;
    private String password;

    // PERSONAL INFORMATION
    private String name;
    private String aboutMe;
    private Date birthDay;
    private Gender gender;
    private String city;

    // GAME INFORMATION
    private Double height;
    private Double weight;

    //CLUB INFO
    private String tradingName;
    private String corporateName;
    private String cnpj;
}
