package com.retalho.ba.utils.mappers;

import com.retalho.ba.adapter.inbound.controller.request.UserRequestDTO;
import com.retalho.ba.adapter.inbound.controller.response.UserResponseDTO;
import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userRequestDTOtoUser(UserRequestDTO userRequestDTO);

    @Mapping(source = "userType", target = "userType")
    UserResponseDTO userToUserResponseDTO(UserEntity user);

}
