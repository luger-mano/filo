package com.retalho.ba.domain.ports.in;

import java.util.UUID;

public interface DeleteUserUseCasePort {
    String execute(UUID id);
}
