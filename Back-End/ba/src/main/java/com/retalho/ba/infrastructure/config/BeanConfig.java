package com.retalho.ba.infrastructure.config;

import com.retalho.ba.adapter.outbound.repositories.DeleteUserAdapter;
import com.retalho.ba.adapter.outbound.repositories.GetAllUserAdapter;
import com.retalho.ba.adapter.outbound.repositories.SaveUserAdapter;
import com.retalho.ba.adapter.outbound.repositories.UpdateUserAdapter;
import com.retalho.ba.domain.ports.in.DeleteUserUseCasePort;
import com.retalho.ba.domain.ports.in.SaveUserUseCasePort;
import com.retalho.ba.domain.ports.in.GetAllUserUseCasePort;
import com.retalho.ba.domain.ports.in.UpdateUserUseCasePort;
import com.retalho.ba.domain.usecase.DeleteUserUseCase;
import com.retalho.ba.domain.usecase.SaveUserUseCase;
import com.retalho.ba.domain.usecase.GetAllUserUseCase;
import com.retalho.ba.domain.usecase.UpdateUserUseCase;
import com.retalho.ba.utils.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public SaveUserUseCasePort saveUserUseCasePort(SaveUserAdapter saveUserAdapter, UserMapper map){
        return new SaveUserUseCase(saveUserAdapter, map);
    }

    @Bean
    public GetAllUserUseCasePort getUserByIdUseCasePort(GetAllUserAdapter getAllUserAdapter, UserMapper map) {
        return new GetAllUserUseCase(getAllUserAdapter, map);
    }

    @Bean
    public UpdateUserUseCasePort updateUserUseCasePort(UpdateUserAdapter updateUserAdapter, UserMapper map) {
        return new UpdateUserUseCase(updateUserAdapter, map);
    }

    @Bean
    public DeleteUserUseCasePort deleteUserUseCasePort(DeleteUserAdapter deleteUserAdapter) {
        return new DeleteUserUseCase(deleteUserAdapter);
    }

}
