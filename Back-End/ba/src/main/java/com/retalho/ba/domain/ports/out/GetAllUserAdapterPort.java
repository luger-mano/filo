package com.retalho.ba.domain.ports.out;

import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.user.User;
import com.retalho.ba.infrastructure.exceptions.UsersNotFoundException;

import java.util.List;

public interface GetAllUserAdapterPort {
    List<UserEntity> getUsers() throws UsersNotFoundException;
}
