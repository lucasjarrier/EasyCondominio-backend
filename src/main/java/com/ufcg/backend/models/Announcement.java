package com.ufcg.backend.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String dtCreated;

    private Date dtExpire;

    private Boolean important;

    private Boolean notExpire;

    public Announcement(String title, String description, Date dtExpire, Boolean important, Boolean notExpire) {
        this.title = title;
        this.description = description;
        this.dtExpire = dtExpire;
        this.important = important;
        this.notExpire = notExpire;

        // Salva a data de criação automaticamente.
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.dtCreated = formatter.format(new Date());
    }
}
