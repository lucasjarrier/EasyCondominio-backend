package com.ufcg.backend.services;

import com.ufcg.backend.models.AreaComum;
import com.ufcg.backend.repositories.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaComumService {

    @Autowired
    private AreaComumRepository areaComumRepository;

    public AreaComum save(AreaComum areaComum) {
        return areaComumRepository.save(areaComum);
    }

    public List<AreaComum> getAllAreas() {
        return new ArrayList<>(areaComumRepository.findAll());
    }

    public AreaComum getAreaComumById(Long id) {
        return areaComumRepository.findById(id).orElse(null);
    }

    public Boolean deleteAreaById(Long id) {
        if(getAreaComumById(id) != null) {
            areaComumRepository.deleteById(id);
            return true;
        }
        return false;
    }
 }
