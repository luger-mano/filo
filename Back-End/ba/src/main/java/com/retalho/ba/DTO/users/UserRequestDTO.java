package com.retalho.ba.DTO.users;

import lombok.Data;

import java.util.Date;
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
    private Date birth;
    private Boolean isArtist;
}
