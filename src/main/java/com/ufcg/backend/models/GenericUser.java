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
import java.util.Locale;

@Getter
@Setter
@Entity
@NoArgsConstructor
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
    private Boolean isAdmin;

    public GenericUser(UserDTO userDTO) {
        this.login = userDTO.getLogin().toLowerCase();
        this.password = userDTO.getPassword();
        this.name = userDTO.getName();
        this.gender = userDTO.getGender();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.apartment = userDTO.getApartment();
        this.isAdmin = false;
    }
}
