package com.ufcg.backend.security;

public class AuthResponse {

    private final String token;
    private final Long idUser;

    public AuthResponse(String token, Long idUser) {
        this.token = token;
        this.idUser = idUser;
    }

    public String getToken(){
        return token;
    }

    public Long getIdUser(){
        return idUser;
    }
}

