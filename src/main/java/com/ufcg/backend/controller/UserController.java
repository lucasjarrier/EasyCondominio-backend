package com.ufcg.backend.controller;

import com.ufcg.backend.dto.UserDTO;
import com.ufcg.backend.dto.renderDTO.RenderMoradorDTO;
import com.ufcg.backend.security.CurrentUser;
import com.ufcg.backend.security.UserPrincipal;
import com.ufcg.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController

@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // OK
    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.save((user)), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<HttpStatus> uploadPhoto(@PathVariable Long id, @RequestParam MultipartFile photo) throws Exception {
        this.userService.uploadPhoto(id, photo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // OK
    @GetMapping
    public ResponseEntity<List<RenderMoradorDTO>>  listUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    // OK
    @GetMapping("/{id}")
    public ResponseEntity<RenderMoradorDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
    }

    // OK
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    // OK
    @PutMapping("/{id}")
    public ResponseEntity<RenderMoradorDTO> userUpdate(@RequestBody UserDTO user, @PathVariable Long id) {
        return new ResponseEntity<>(userService.updateUser(user,id), HttpStatus.ACCEPTED);
    }

    // OK
    // RETORNA O ID DO USUARIO PELO TOKEN DA REQUISIÇÃO
    @GetMapping("/getUserByToken")
    public ResponseEntity<RenderMoradorDTO> getIdUserByToken(@CurrentUser UserPrincipal userPrincipal) {
        return new ResponseEntity<>(userService.findById(userPrincipal.getUser().getId()), HttpStatus.ACCEPTED);
    }
 }
