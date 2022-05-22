package com.ufcg.backend.services;

import com.ufcg.backend.dto.renderDTO.RenderMoradorDTO;
import com.ufcg.backend.dto.UserDTO;
import com.ufcg.backend.models.GenericUser;
import com.ufcg.backend.repositories.GenericUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoded;

    @Autowired
    private GenericUserRepository genericUserRepository;

    public @Valid UserDTO save(@Valid UserDTO user)  {
        GenericUser novoUser = new GenericUser(user);
        novoUser.setPassword(passwordEncoded.encode(user.getPassword()));
        genericUserRepository.save(novoUser);
        return user;
    }

    public RenderMoradorDTO findById(Long id) {
        GenericUser userById = genericUserRepository.findByIdUser(id);
        if(userById != null) {
            return new RenderMoradorDTO(userById);
        }
        return null;
    }

    public void delete(Long id){
        if(findById(id) != null) {
            genericUserRepository.deleteById(id);
        }
    }

    public RenderMoradorDTO updateUser(UserDTO newDataUser, Long id) {

        if(findById(id) != null) {

            GenericUser oldDataUser = this.genericUserRepository.findById(id).get();

            if(!(newDataUser.getName() == null)) {
                oldDataUser.setName(newDataUser.getName());
            }

            if(!(newDataUser.getGender() == null)) {
                oldDataUser.setGender(newDataUser.getGender());
            }

            if(!(newDataUser.getPhoneNumber() == null)) {
                oldDataUser.setPhoneNumber(newDataUser.getPhoneNumber());
            }

            genericUserRepository.save(oldDataUser);

            return new RenderMoradorDTO(oldDataUser);
        }
        return null;
    }

    public List<RenderMoradorDTO> getAllUsers() {

        List<RenderMoradorDTO> userList = new ArrayList<>();

        for(GenericUser user : genericUserRepository.findAll()) {
            if(user.getIsNormalUser()) userList.add(new RenderMoradorDTO(user));
        }
        return userList;
    }

    public void uploadPhoto(Long id, MultipartFile photo) throws Exception {
        try{
            byte[] bytes = photo.getBytes();
            GenericUser user = this.genericUserRepository.findById(id).get();
            user.setPhoto(bytes);
            this.genericUserRepository.save(user);
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Internal error on upload photo");
        }
    }
}
