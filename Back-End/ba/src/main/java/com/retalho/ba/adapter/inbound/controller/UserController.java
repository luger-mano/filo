package com.retalho.ba.adapter.inbound.controller;

import com.retalho.ba.adapter.inbound.controller.request.UserRequestDTO;
import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;
import com.retalho.ba.domain.ports.in.DeleteUserUseCasePort;
import com.retalho.ba.domain.ports.in.SaveUserUseCasePort;
import com.retalho.ba.domain.ports.in.GetAllUserUseCasePort;
import com.retalho.ba.domain.ports.in.UpdateUserUseCasePort;
import com.retalho.ba.infrastructure.exceptions.UsersNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SaveUserUseCasePort saveUserUseCasePort;
    private final GetAllUserUseCasePort getAllUserUseCasePort;
    private final UpdateUserUseCasePort updateUserUseCasePort;
    private final DeleteUserUseCasePort deleteUserUseCasePort;

    @PostMapping
    public ResponseEntity<UserResponseDTO>saveUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        UserResponseDTO user = saveUserUseCasePort.execute(userRequestDTO);
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>>getUsers() throws UsersNotFoundException {
        return ResponseEntity.ok().body(getAllUserUseCasePort.execute());
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserResponseDTO>updateUser(@RequestBody UserRequestDTO userRequestDTO,
                                                     @PathVariable UUID id){
        return ResponseEntity.status(201).body(updateUserUseCasePort.execute(userRequestDTO, id));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable UUID id){
        return ResponseEntity.status(201).body(deleteUserUseCasePort.execute(id));
    }

}
