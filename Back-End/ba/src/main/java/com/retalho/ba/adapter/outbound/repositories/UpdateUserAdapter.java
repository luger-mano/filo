package com.retalho.ba.adapter.outbound.repositories;

import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.ports.out.UpdateUserAdapterPort;
import com.retalho.ba.domain.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Component
public class UpdateUserAdapter implements UpdateUserAdapterPort {
    private final UserRepository repository;

    public UpdateUserAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserEntity> findById(UUID id) {
        return this.repository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return this.repository.save(user);
    }

    @Override
    public Boolean exitsByEmail(String email) {
        return this.repository.existsByEmail(email);
    }
}
