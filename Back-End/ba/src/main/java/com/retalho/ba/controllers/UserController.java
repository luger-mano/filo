package com.retalho.ba.controllers;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.DTO.users.UserResponseDTO;
import com.retalho.ba.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO>saveUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        UserResponseDTO user = userService.saveUser(userRequestDTO);

        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserResponseDTO>updateUser(@RequestBody UserRequestDTO userRequestDTO,
                                                     @PathVariable UUID id){
        return ResponseEntity.status(201).body(userService.updateUser(userRequestDTO, id));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable UUID id){
        return ResponseEntity.status(201).body(userService.deleteUser(id));
    }


    @GetMapping("/artists")
    public ResponseEntity<List<UserResponseDTO>>getArtists(){
        return ResponseEntity.ok().body(userService.getArtists());
    }



}
