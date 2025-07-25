package com.retalho.ba.adapter.inbound.controller.request;

import com.retalho.ba.domain.enums.UserType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserRequestDTO {

    private UUID userId;
    @NotBlank(message = "O campo name não pode estar em branco.")
    private String name;
    @NotBlank(message = "O campo middleName não pode estar em branco.")
    private String middleName;
    @NotBlank(message = "O campo email não pode estar em branco.")
    private String email;
    @NotBlank(message = "O campo password não pode estar em branco.")
    private String password;
    @NotBlank(message = "O campo cpf não pode estar em branco.")
    private String cpf;
    @NotBlank(message = "O campo phone não pode estar em branco.")
    private String phone;
    @NotNull(message = "O campo birth não pode ser nulo.")
    private LocalDate birth;

    public UserRequestDTO(UUID userId,
                          String name,
                          String middleName,
                          String email,
                          String password,
                          String cpf,
                          String phone,
                          LocalDate birth,
                          UserType userType) {
        this.userId = userId;
        this.name = name;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.birth = birth;
    }
}
