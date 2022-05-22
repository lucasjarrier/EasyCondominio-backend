package com.ufcg.backend.models;

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
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // SECURITY

    @NotNull
    @Email
    @Column(unique = true)
    private String login;

    @NotNull
    @NotEmpty(message = "Senha Vazia")
    @Column
    private String password;

    // PERSONAL INFORMATION

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private Date birthDay;

    @NotNull
    @Column
    private Gender gender;

    @NotNull
    @Column
    private String city;

}
