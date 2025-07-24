package com.retalho.ba.domain.usecase;

import com.retalho.ba.adapter.inbound.controller.request.UserRequestDTO;
import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;
import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.enums.UserType;
import com.retalho.ba.domain.ports.in.UpdateUserUseCasePort;
import com.retalho.ba.domain.ports.out.UpdateUserAdapterPort;
import com.retalho.ba.utils.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public class UpdateUserUseCase implements UpdateUserUseCasePort {

    private final UpdateUserAdapterPort updateUserAdapterPort;

    private final UserMapper userMapper;

    public UpdateUserUseCase(UpdateUserAdapterPort updateUserAdapterPort, UserMapper userMapper) {
        this.updateUserAdapterPort = updateUserAdapterPort;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO execute(UserRequestDTO request, UUID id) {
        if (!this.updateUserAdapterPort.exitsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse e-mail.");
        }
        UserEntity existingUser = this.updateUserAdapterPort.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuário com id " + id + " não encontrado"));
        existingUser.setName(request.getName());
        existingUser.setMiddleName(request.getMiddleName());
        existingUser.setEmail(request.getEmail());
        existingUser.setPassword(request.getPassword());
        existingUser.setCpf(request.getCpf());
        existingUser.setPhone(request.getPhone());
        existingUser.setBirth(request.getBirth());
        existingUser.setUserType(UserType.CLIENT);

        UserEntity updated = this.updateUserAdapterPort.saveUser(existingUser);

        return userMapper.userToUserResponseDTO(updated);
    }
}
