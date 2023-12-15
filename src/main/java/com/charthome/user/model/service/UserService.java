package com.charthome.user.model.service;

import com.charthome.user.model.dto.UserDTO;
import com.charthome.user.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    void save(UserEntity user);

    Optional<UserEntity> findUserByUserId(String userId);

    UserDTO updateProfile(UserDTO user);
}
