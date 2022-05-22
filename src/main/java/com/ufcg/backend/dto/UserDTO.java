package com.ufcg.backend.dto;

import com.ufcg.backend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    // ID User
    private Long id;

    // SECURITY
    private String login;
    private String password;

    // PERSONAL INFORMATION
    private String name;
    private Gender gender;

    // CONTACT INFORMATION
    private String phoneNumber;
    private String apartment;

}
