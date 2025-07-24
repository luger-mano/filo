package com.retalho.ba.domain.ports.in;

import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;
import com.retalho.ba.domain.user.User;
import com.retalho.ba.infrastructure.exceptions.UsersNotFoundException;

import java.util.List;

public interface GetAllUserUseCasePort {
    List<UserResponseDTO> execute() throws UsersNotFoundException;
}
