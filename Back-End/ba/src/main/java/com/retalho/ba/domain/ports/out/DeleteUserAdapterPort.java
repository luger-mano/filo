package com.retalho.ba.domain.ports.out;

import java.util.UUID;

public interface DeleteUserAdapterPort {
    void deleteUser(UUID id);
}
