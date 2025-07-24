package com.retalho.ba.domain.ports.out;

import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UpdateUserAdapterPort {
    Optional<UserEntity> findById(UUID id);
    UserEntity saveUser(UserEntity userEntity);
    Boolean exitsByEmail(String email);
}
