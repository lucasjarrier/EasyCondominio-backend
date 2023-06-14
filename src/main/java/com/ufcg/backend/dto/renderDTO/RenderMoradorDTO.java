package com.ufcg.backend.dto.renderDTO;

import com.ufcg.backend.enums.Gender;
import com.ufcg.backend.models.GenericUser;

public class RenderMoradorDTO {

    private Long id;
    private String name;
    private Gender gender;
    private String phoneNumber;
    private String apartment;
    private byte[] photo;
    private boolean isAdmin;

    public RenderMoradorDTO(GenericUser user) {
        this.phoneNumber = user.getPhoneNumber();
        this.id = user.getId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.photo = user.getPhoto();
        this.apartment = user.getApartment();
        this.isAdmin = (user.getAdmin() != null && user.getAdmin());
    }

    public RenderMoradorDTO() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
