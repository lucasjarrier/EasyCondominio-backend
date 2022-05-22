package com.ufcg.backend.dto.renderDTO;

import com.ufcg.backend.enums.Gender;
import com.ufcg.backend.models.GenericUser;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class RenderMoradorDTO {

    private Long id;

    private String name;

    private Gender gender;

    private String phoneNumber;

    private String apartment;

    private byte[] photo;

    public RenderMoradorDTO(GenericUser user) {
        this.phoneNumber = user.getPhoneNumber();
        this.id = user.getId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.photo = user.getPhoto();
        this.apartment = user.getApartment();
    }
}
