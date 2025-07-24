package com.retalho.ba.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserServiceImplTest {

//    @InjectMocks
//    private UserServiceImpl userServiceImpl;
//    @Mock
//    private JpaUserRepository jpaUserRepository;
//    @Mock
//    private UserMapper userMapper;
//
//    private UserRequestDTO data;
//
//    @BeforeEach
//    void setup() {
//        data = new UserRequestDTO(UUID.randomUUID(), "Lucas",
//                "Germano",
//                "germanoluc890@gmail.com",
//                "Steve3571",
//                "527.253.208-28",
//                "(11) 97130-2771",
//                LocalDate.of(2004, 6, 10),
//                UserType.ADMIN);
//    }
//
//    @Test
//    @DisplayName("Should throw 409 if email already exists.")
//    void saveUserCase1() {
//        when(jpaUserRepository.existsByEmail(data.getEmail())).thenReturn(true);
//
//        ResponseStatusException exception = assertThrows(ResponseStatusException.class, ()->{
//            userServiceImpl.saveUser(data);
//        });
//
//        assertEquals(HttpStatus.CONFLICT, exception.getStatusCode());
//        assertEquals("Email already exists.", exception.getReason());
//
//        verify(jpaUserRepository, never()).save(any());
//    }
//
//    @Test
//    @DisplayName("Should create user when email does not exist")
//    void saveUserCase2() {
//        when(jpaUserRepository.existsByEmail(data.getEmail())).thenReturn(false);
//
//        User user = new User(data);
//        UserResponseDTO response = new UserResponseDTO(user);
//
//        when(userMapper.userRequestDTOtoUser(data)).thenReturn(user);
//        when(jpaUserRepository.save(any(User.class))).thenReturn(user);
//        when(userMapper.userToUserResponseDTO(user)).thenReturn(response);
//
//        UserResponseDTO request = userServiceImpl.saveUser(data);
//        assertNotNull(request);
//        assertEquals(request.getEmail(), response.getEmail());
//
//        verify(jpaUserRepository, Mockito.times(1)).save(any(User.class));
//
//    }
}