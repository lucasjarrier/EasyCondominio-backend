package com.ufcg.backend.dto;

import com.ufcg.backend.enums.Gender;

import java.util.Date;

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

    public UserUpdateDTO(String name, String aboutMe, Date birthDay, Gender gender, String city,
                         Double height, Double weight) {
        this.name = name;
        this.aboutMe = aboutMe;
        this.birthDay = birthDay;
        this.gender = gender;
        this.city = city;
        this.height = height;
        this.weight = weight;
    }

    public UserUpdateDTO() {
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
}