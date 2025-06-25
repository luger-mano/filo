package com.retalho.ba.DTO;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {
    private UUID userId;
    private String name;
    private String email;
    private String phone;
}
