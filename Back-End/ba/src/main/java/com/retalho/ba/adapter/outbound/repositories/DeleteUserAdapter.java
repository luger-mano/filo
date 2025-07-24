package com.retalho.ba.adapter.outbound.repositories;

import com.retalho.ba.domain.ports.out.DeleteUserAdapterPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserAdapter implements DeleteUserAdapterPort {

    private final UserRepository userRepository;

    public DeleteUserAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void deleteUser(UUID id) {
        this.userRepository.deleteById(id);;
    }
}
