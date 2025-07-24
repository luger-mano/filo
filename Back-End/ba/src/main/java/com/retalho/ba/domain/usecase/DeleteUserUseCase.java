package com.retalho.ba.domain.usecase;

import com.retalho.ba.domain.ports.in.DeleteUserUseCasePort;
import com.retalho.ba.domain.ports.out.DeleteUserAdapterPort;

import java.util.UUID;

public class DeleteUserUseCase implements DeleteUserUseCasePort {
    private final DeleteUserAdapterPort deleteUserAdapterPort;

    public DeleteUserUseCase(DeleteUserAdapterPort deleteUserAdapterPort) {
        this.deleteUserAdapterPort = deleteUserAdapterPort;
    }

    @Override
    public String execute(UUID id) {
        this.deleteUserAdapterPort.deleteUser(id);
        return "Usuário com id " + id + " deletado com sucesso.";
    }
}
