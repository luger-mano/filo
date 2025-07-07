package com.retalho.ba.repositories;

import com.retalho.ba.DTO.users.UserRequestDTO;
import com.retalho.ba.models.User;
import com.retalho.ba.models.UserType;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    @DisplayName("Should return an email existing from DB h2.")
    void existsByEmailCase1() {
        String email = "germanoluc890@gmail.com";
        User user = new User();
                user.setName("Lucas");
                user.setMiddleName("Germano");
                user.setEmail(email);
                user.setPassword("Steve3571");
                user.setCpf("527.253.208-28");
                user.setPhone("(11) 97130-2771");
                user.setBirth(LocalDate.of(2004, 6, 10));
                user.setUserType(UserType.ARTIST);

        entityManager.persistAndFlush(user);

        Boolean result = this.userRepository.existsByEmail(email);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Should not return an email existing from DB h2.")
    void existsByEmailCase2() {
        String email = "germanoluc890@gmail.com";

        Boolean result = this.userRepository.existsByEmail(email);

        assertThat(result).isFalse();
    }
}