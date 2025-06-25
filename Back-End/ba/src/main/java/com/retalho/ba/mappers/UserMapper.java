package com.retalho.ba.mappers;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.DTO.UserResponseDTO;
import com.retalho.ba.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestDTOtoUser(UserRequestDTO userRequestDTO);

    UserResponseDTO userToUserResponseDTO(User user);
}
