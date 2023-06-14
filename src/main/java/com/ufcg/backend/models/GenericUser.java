package com.ufcg.backend.models;

import com.ufcg.backend.dto.UserDTO;
import com.ufcg.backend.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
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

    public GenericUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}