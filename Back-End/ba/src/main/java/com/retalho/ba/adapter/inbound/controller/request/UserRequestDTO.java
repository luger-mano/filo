package com.retalho.ba.adapter.inbound.controller.request;

import com.retalho.ba.domain.enums.UserType;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserRequestDTO {

    private UUID userId;
    private String name;
    private String middleName;
    private String email;
    private String password;
    private String cpf;
    private String phone;
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
