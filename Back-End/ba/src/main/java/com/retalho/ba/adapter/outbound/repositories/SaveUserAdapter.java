package com.retalho.ba.adapter.outbound.repositories;

import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.ports.out.SaveUserAdapterPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class SaveUserAdapter implements SaveUserAdapterPort {

    private final UserRepository repository;

    public SaveUserAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserEntity saveUser(UserEntity userEntity) {
        return this.repository.save(userEntity);
    }
}
