package com.charthome.user.repository;

import com.charthome.user.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

    public Optional<UserEntity> findByUserId(String userId);
}
