package com.ufcg.backend.services;

import com.ufcg.backend.enums.Gender;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GenderService {

    public Object[] listarSexo() {
        return Arrays.stream(Gender.values()).toArray();
    }
}
