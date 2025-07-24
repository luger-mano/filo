package com.retalho.ba.domain.ports.in;

import com.retalho.ba.adapter.inbound.controller.request.UserRequestDTO;
import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;

public interface SaveUserUseCasePort {
    UserResponseDTO execute(UserRequestDTO user);
}
