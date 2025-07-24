package com.retalho.ba.adapter.outbound.repositories;

import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.ports.out.GetAllUserAdapterPort;
import com.retalho.ba.domain.user.User;
import com.retalho.ba.infrastructure.exceptions.UsersNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
@Component
public class GetAllUserAdapter implements GetAllUserAdapterPort {

    private final UserRepository repository;

    public GetAllUserAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserEntity> getUsers() throws UsersNotFoundException {
        try{
            return this.repository.findAll().stream().map(userEntity -> new UserEntity(userEntity.getUserId(), userEntity.getName(), userEntity.getMiddleName(),
                    userEntity.getEmail(), userEntity.getPassword(), userEntity.getCpf(), userEntity.getPhone(),
                    userEntity.getBirth(), userEntity.getUserType())).toList();
        }catch (Exception e){
            throw new UsersNotFoundException("Não foi encontrado nenhum usuário.", e);
        }
    }
}
