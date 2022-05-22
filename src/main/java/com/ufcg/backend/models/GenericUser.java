package com.ufcg.backend.models;

import com.ufcg.backend.dto.UserDTO;
import com.ufcg.backend.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TB_GENERIC_USER")
public class GenericUser {

    // SECURITY

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Column(unique = true)
    private String login;

    @NotNull
    @NotEmpty(message = "Senha Vazia")
    @Column
    private String password;

    // USER NORMAL INFORMATION'S

    @Column
    private String name;

    @Column
    private Gender gender;

    @Column
    private byte[] photo;

    @Column
    private String apartment;

    // CONTACT INFORMATION
    @Column
    private String phoneNumber;

    // GENERAL INFORMATION
    @Column
    private Boolean isNormalUser;

    public GenericUser(UserDTO userDTO) {
        this.login = userDTO.getLogin();
        this.password = userDTO.getPassword();
        this.name = userDTO.getName();
        this.gender = userDTO.getGender();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.apartment = userDTO.getApartment();
        this.isNormalUser = true;
    }
}
