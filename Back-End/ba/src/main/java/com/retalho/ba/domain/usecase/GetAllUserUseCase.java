package com.retalho.ba.domain.usecase;

import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;
import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.ports.in.GetAllUserUseCasePort;
import com.retalho.ba.domain.ports.out.GetAllUserAdapterPort;
import com.retalho.ba.domain.user.User;
import com.retalho.ba.infrastructure.exceptions.UsersNotFoundException;
import com.retalho.ba.utils.mappers.UserMapper;

import java.util.List;

public class GetAllUserUseCase implements GetAllUserUseCasePort {

    private final GetAllUserAdapterPort getAllUserAdapterPort;

    private final UserMapper userMapper;

    public GetAllUserUseCase(GetAllUserAdapterPort getAllUserAdapterPort, UserMapper userMapper) {
        this.getAllUserAdapterPort = getAllUserAdapterPort;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponseDTO> execute() throws UsersNotFoundException {
        List<UserEntity> users = this.getAllUserAdapterPort.getUsers();
        return users.stream().map(this.userMapper::userToUserResponseDTO).toList();
    }
}
