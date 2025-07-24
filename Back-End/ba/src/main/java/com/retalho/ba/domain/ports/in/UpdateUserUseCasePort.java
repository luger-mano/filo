package com.retalho.ba.domain.ports.in;

import com.retalho.ba.adapter.inbound.controller.request.UserRequestDTO;
import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;

import java.util.UUID;

public interface UpdateUserUseCasePort {
    UserResponseDTO execute(UserRequestDTO dto, UUID id);
}
