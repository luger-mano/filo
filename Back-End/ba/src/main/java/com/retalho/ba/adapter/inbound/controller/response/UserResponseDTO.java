package com.retalho.ba.adapter.inbound.controller.response;

import com.retalho.ba.domain.user.User;
import com.retalho.ba.domain.enums.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserResponseDTO {
    private UUID userId;
    private String name;
    private String email;
    private String phone;
    private UserType userType;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.userType = user.getUserType();
    }
}
