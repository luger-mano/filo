package com.retalho.ba.repositories;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.models.User;
import com.retalho.ba.models.UserType;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;


    @Test
    @DisplayName("Should return an email existing from DB h2.")
    void existsByEmailCase1() {
        String email = "germanoluc890@gmail.com";
        UserRequestDTO data = new UserRequestDTO(UUID.randomUUID(),"Lucas",
                "Germano",
                email,
                "Steve3571",
                "527.253.208-28",
                "(11) 97130-2771",
                LocalDate.of(2004, 6, 10),
                UserType.ARTIST);

        this.createUser(data);
        Boolean result = this.userRepository.existsByEmail(email);

        assertThat(result == true).isTrue();
    }

    @Test
    @DisplayName("Should not return an email existing from DB h2.")
    void existsByEmailCase2() {
        String email = "germanoluc890@gmail.com";

        Boolean result = this.userRepository.existsByEmail(email);

        assertThat(result == false).isTrue();
    }


    private void createUser(UserRequestDTO data) {
        User user = new User(data);
        this.entityManager.persist(user);
    }
}