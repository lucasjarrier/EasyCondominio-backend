package com.ufcg.backend.services;

import com.ufcg.backend.models.GenericUser;
import com.ufcg.backend.repositories.GenericUserRepository;
import com.ufcg.backend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final GenericUserRepository genericUserRepository;

    @Autowired
    public CustomerUserDetailsService(GenericUserRepository genericUserRepository) {
        this.genericUserRepository = genericUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login){
        GenericUser user = genericUserRepository.findByLogin(login);
        if(user == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        } else {
            return UserPrincipal.create(user);
        }
    }

    public UserDetails loadUserById(long id) {
        GenericUser user = genericUserRepository.findById(id).orElse(null);
        if(user != null) {
            return UserPrincipal.create(user);
        }
        return null;
    }
}

