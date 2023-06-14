package com.ufcg.backend.dto;

import com.ufcg.backend.enums.Gender;

import java.util.Date;

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

    // CLUB INFO
    private String tradingName;
    private String corporateName;
    private String cnpj;

    public CreateUserDTO(String login, String password, String name, String aboutMe, Date birthDay, Gender gender,
                         String city, Double height, Double weight, String tradingName, String corporateName,
                         String cnpj) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.aboutMe = aboutMe;
        this.birthDay = birthDay;
        this.gender = gender;
        this.city = city;
        this.height = height;
        this.weight = weight;
        this.tradingName = tradingName;
        this.corporateName = corporateName;
        this.cnpj = cnpj;
    }

    public CreateUserDTO() {
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTradingName() {
        return tradingName;
    }

    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}