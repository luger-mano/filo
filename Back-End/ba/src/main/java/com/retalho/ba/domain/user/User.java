package com.retalho.ba.domain.user;


import com.retalho.ba.adapter.outbound.entities.UserEntity;
import com.retalho.ba.domain.enums.UserType;

import java.time.LocalDate;
import java.util.UUID;


public class User {

    private UUID userId;
    private String name;
    private String middleName;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private LocalDate birth;
    private UserType userType;

    public User() {
    }

    public User(UUID userId, String name, String middleName, String email,
                String password, String cpf, String phone, LocalDate birth,
                UserType userType) {
        this.userId = userId;
        this.name = name;
        this.middleName = middleName;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.phone = phone;
        this.birth = birth;
        this.userType = userType;
    }

    public static User fromEntity(UserEntity userEntity) {
        return new User(userEntity.getUserId(), userEntity.getName(), userEntity.getMiddleName(),
                userEntity.getEmail(), userEntity.getPassword(), userEntity.getCpf(), userEntity.getPhone(),
                userEntity.getBirth(), userEntity.getUserType());
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
