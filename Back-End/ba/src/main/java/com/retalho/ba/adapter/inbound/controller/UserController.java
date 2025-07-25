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

/**
 * Controlador responsável por gerenciar as operações relacionadas aos usuários.
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final SaveUserUseCasePort saveUserUseCasePort;
    private final GetAllUserUseCasePort getAllUserUseCasePort;
    private final UpdateUserUseCasePort updateUserUseCasePort;
    private final DeleteUserUseCasePort deleteUserUseCasePort;

    /**
     * Cria um novo usuário
     *
     * @param userRequestDTO Objeto UserRequestDTO contendo os dados do novo usuário.
     * @return O objeto UserResponseDTO criado, com os dados filtrados do usuário (sem expor dados).
     */
    @PostMapping
    public ResponseEntity<UserResponseDTO>saveUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        UserResponseDTO user = saveUserUseCasePort.execute(userRequestDTO);
        return ResponseEntity.ok(user);
    }
    /**
     * Cria um novo usuário
     *
     * @return O objeto UserResponseDTO criado, com ID preenchido.
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>>getUsers() throws UsersNotFoundException {
        return ResponseEntity.ok().body(getAllUserUseCasePort.execute());
    }
    /**
     * Cria um novo usuário
     *
     * @param userRequestDTO Objeto UserRequestDTO contendo os dados do novo usuário.
     * @param id Objeto UUID é passado o id para atualizar determinado usuário.
     * @return O objeto UserResponseDTO criado, com os dados filtrados do usuário (sem expor dados).
     */
    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserResponseDTO>updateUser(@RequestBody @Valid UserRequestDTO userRequestDTO,
                                                     @PathVariable UUID id){
        return ResponseEntity.status(201).body(updateUserUseCasePort.execute(userRequestDTO, id));
    }
    /**
     * Cria um novo usuário
     *
     * @param id Objeto UUID é passado o id para deletar determinado usuário.
     * @return O objeto String com uma mensagem de confirmação da deleção.
     */
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable UUID id){
        return ResponseEntity.status(201).body(deleteUserUseCasePort.execute(id));
    }

}
