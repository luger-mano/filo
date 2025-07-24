package com.retalho.ba.adapter.outbound.entities;

import com.retalho.ba.domain.enums.UserType;
import com.retalho.ba.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TABLE_USERS")
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private UUID userId;
    private String name;
    private String middleName;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private LocalDate birth;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public UserEntity(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.middleName = user.getMiddleName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.cpf = user.getCpf();
        this.phone = user.getPhone();
        this.birth = user.getBirth();
        this.userType = user.getUserType();
    }

}
