package com.ufcg.backend.controller;

import com.ufcg.backend.models.GenericUser;
import com.ufcg.backend.repositories.GenericUserRepository;
import com.ufcg.backend.security.AuthResponse;
import com.ufcg.backend.security.CurrentUser;
import com.ufcg.backend.security.TokenProvider;
import com.ufcg.backend.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class GenericUserController {

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private GenericUserRepository genericUserRepository;

    // OK
    @PostMapping
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody GenericUser user) {
        Authentication authentication = null;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getLogin(),
                            user.getPassword()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        assert authentication != null;
        String token = tokenProvider.createTokenUser(authentication);
        Long idUser = genericUserRepository.findByLogin(user.getLogin()).getId();
        return ResponseEntity.ok(new AuthResponse(token, idUser));
    }

    // OK
    @GetMapping("/logout")
    public void deslog() {
        SecurityContextHolder.clearContext();
    }

    // OK
    // RETORNA O ID DO USUARIO PELO TOKEN DA REQUISIÇÃO
    @GetMapping("/getIdUserByToken")
    public ResponseEntity<Long> getIdUserByToken(@CurrentUser UserPrincipal userPrincipal) {
        return new ResponseEntity<>(userPrincipal.getUser().getId(), HttpStatus.ACCEPTED);
    }
}
