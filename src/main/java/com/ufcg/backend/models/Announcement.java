package com.ufcg.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
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

    public Announcement() {
        // Construtor vazio necessário para a entidade do JPA
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Date getDtExpire() {
        return dtExpire;
    }

    public void setDtExpire(Date dtExpire) {
        this.dtExpire = dtExpire;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean getNotExpire() {
        return notExpire;
    }

    public void setNotExpire(Boolean notExpire) {
        this.notExpire = notExpire;
    }
}