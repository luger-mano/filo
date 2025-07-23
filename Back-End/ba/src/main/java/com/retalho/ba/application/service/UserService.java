package com.retalho.ba.application.service;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.DTO.users.UserResponseDTO;
import com.retalho.ba.utils.mappers.UserMapper;
import com.retalho.ba.domain.user.User;
import com.retalho.ba.adapters.outbound.repositories.UserRepository;
import org.springframework.http.HttpStatus;
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
    public UserResponseDTO saveUser(UserRequestDTO request) {
        if(this.userRepository.existsByEmail(request.getEmail())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists.");
        }

        User userSave = userMapper.userRequestDTOtoUser(request);
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
                .filter(c -> c.getUserType().equals(getArtists()))
                .map(userMapper::userToUserResponseDTO)
                .toList();
    }

}
