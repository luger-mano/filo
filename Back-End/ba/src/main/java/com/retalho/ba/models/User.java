package com.retalho.ba.models;


import com.retalho.ba.DTO.users.UserRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_users")
public class User implements Serializable {

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

    public User(UserRequestDTO user){
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
