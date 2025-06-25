package com.retalho.ba.services;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.DTO.UserResponseDTO;
import com.retalho.ba.mappers.UserMapper;
import com.retalho.ba.models.User;
import com.retalho.ba.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    final UserRepository userRepository;

    final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User userSave = userMapper.userRequestDTOtoUser(userRequestDTO);
        userRepository.save(userSave);

        return userMapper.userToUserResponseDTO(userSave);
    }

    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::userToUserResponseDTO).toList();
    }

    @Transactional
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, UUID id){
        Boolean userEmail = userRepository.existsByEmail(userRequestDTO.getEmail());
        if (!userEmail){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse e-mail.");
        }

        User user = userRepository.findById(id).orElseThrow();

        user.setName(userRequestDTO.getName());
        user.setMiddleName(userRequestDTO.getMiddleName());
        user.setCpf(userRequestDTO.getCpf());
        user.setPhone(userRequestDTO.getPhone());
        user.setBirth(userRequestDTO.getBirth());

        return userMapper.userToUserResponseDTO(user);
    }

    @Transactional
    public String deleteUser(UUID id){
        userRepository.deleteById(id);

        return "Usuário deletado com sucesso!";
    }


    public List<UserResponseDTO> getArtists(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .filter(c -> c.getIsArtist() == true)
                .map(userMapper::userToUserResponseDTO)
                .toList();
    }

}
