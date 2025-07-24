package com.retalho.ba.adapter.outbound.repositories;

import com.retalho.ba.adapter.outbound.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Boolean existsByEmail(String email);
}
