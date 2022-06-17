package com.ufcg.backend.services;

import com.ufcg.backend.dto.AreaDTO;
import com.ufcg.backend.models.AreaComum;
import com.ufcg.backend.repositories.AreaComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaComumService {

    @Autowired
    private AreaComumRepository areaComumRepository;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private AutoSistemService autoSistemService;

    public void save(AreaDTO areaDTO) throws Exception {
        areaComumRepository.save(new AreaComum(areaDTO));
    }

    /**
     * Refazer esse metodo!
     */
    public void uploadPhoto(Long id, MultipartFile photo) throws Exception {
        try {
            byte[] bytes = photo.getBytes();
            AreaComum areaComum = this.areaComumRepository.findById(id).get();
            areaComum.setPhoto(bytes);
            this.areaComumRepository.save(areaComum);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro ao salvar foto!");
        }
    }

    public void criarReservaAutomatica() {
        autoSistemService.createReservasDiarias();
    }

    public List<AreaComum> getAllAreas() {
        return new ArrayList<>(areaComumRepository.findAll());
    }

    public AreaComum getAreaComumById(Long id) {
        return areaComumRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteAreaById(Long id) {
        if (getAreaComumById(id) != null) {
            areaComumRepository.deleteById(id);
            reservaService.deletarReservasByIdArea(id);
        }
    }
}
