package com.retalho.ba.domain.usecase;

import com.retalho.ba.adapter.inbound.controller.request.UserRequestDTO;
import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;
import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.enums.UserType;
import com.retalho.ba.domain.ports.in.SaveUserUseCasePort;
import com.retalho.ba.domain.ports.out.SaveUserAdapterPort;
import com.retalho.ba.domain.user.User;
import com.retalho.ba.utils.mappers.UserMapper;

public class SaveUserUseCase implements SaveUserUseCasePort {

    private final SaveUserAdapterPort saveUserAdapterPort;

    private final UserMapper userMapper;

    public SaveUserUseCase(SaveUserAdapterPort saveUserAdapterPort, UserMapper userMapper) {
        this.saveUserAdapterPort = saveUserAdapterPort;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO execute(UserRequestDTO request) {
        UserEntity userSave = this.userMapper.userRequestDTOtoUser(request);
        userSave.setUserType(UserType.CLIENT);
        this.saveUserAdapterPort.saveUser(userSave);

        return this.userMapper.userToUserResponseDTO(userSave);
    }
}
