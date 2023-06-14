package com.ufcg.backend.dto;

import com.ufcg.backend.enums.Gender;

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

    public UserDTO(Long id, String login, String password, String name, Gender gender, String phoneNumber,
                   String apartment) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.apartment = apartment;
    }

    public UserDTO() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}