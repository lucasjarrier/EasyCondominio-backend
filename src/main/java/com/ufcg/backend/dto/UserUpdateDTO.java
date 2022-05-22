package com.ufcg.backend.dto;

import com.ufcg.backend.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdateDTO {

    // PERSONAL INFORMATION TO CHANGES

    private String name;
    private String aboutMe;
    private Date birthDay;
    private Gender gender;
    private String city;

    // GAME INFORMATION TO CHANGES

    private Double height;
    private Double weight;

}
