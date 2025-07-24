package com.retalho.ba.domain.ports.out;

import com.retalho.ba.adapter.outbound.entities.UserEntity;

public interface SaveUserAdapterPort {
    UserEntity saveUser(UserEntity userEntity);
}
