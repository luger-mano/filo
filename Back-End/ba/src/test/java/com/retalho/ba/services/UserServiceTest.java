package com.retalho.ba.services;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.DTO.users.UserResponseDTO;
import com.retalho.ba.mappers.UserMapper;
import com.retalho.ba.models.User;
import com.retalho.ba.models.UserType;
import com.retalho.ba.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.UUID;

import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    private UserRequestDTO data;

    @BeforeEach
    void setup() {
        data = new UserRequestDTO(UUID.randomUUID(), "Lucas",
                "Germano",
                "germanoluc890@gmail.com",
                "Steve3571",
                "527.253.208-28",
                "(11) 97130-2771",
                LocalDate.of(2004, 6, 10),
                UserType.ARTIST);
    }

    @Test
    @DisplayName("Should throw 409 if email already exists.")
    void saveUserCase1() {
        when(userRepository.existsByEmail(data.getEmail())).thenReturn(true);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, ()->{
            userService.saveUser(data);
        });

        assertEquals(HttpStatus.CONFLICT, exception.getStatusCode());
        assertEquals("Email already exists.", exception.getReason());

        verify(userRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should create user when email does not exist")
    void saveUserCase2() {
        when(userRepository.existsByEmail(data.getEmail())).thenReturn(false);
        
        User user = new User(data);
        UserResponseDTO response = new UserResponseDTO(user);

        when(userMapper.userRequestDTOtoUser(data)).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.userToUserResponseDTO(user)).thenReturn(response);

        UserResponseDTO request = userService.saveUser(data);
        assertNotNull(request);
        assertEquals(request.getEmail(), response.getEmail());

        verify(userRepository, Mockito.times(1)).save(any(User.class));

    }
}