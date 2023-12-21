package com.charthome.user.model.service;

import com.charthome.user.model.dto.UserDto;
import com.charthome.user.model.entity.UserEntity;
import com.charthome.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void save(UserEntity user) {
        userRepository.save(user);
    }


    @Override
    public Optional<UserEntity> findUserByUserId(String userId) {
    return userRepository.findUserByUserId(userId);
}

    @Override
    public UserDto updateProfile(UserDto user) {
        Optional<UserEntity> fintUserEntity = userRepository.findUserByUserId(user.getUserId());
        UserEntity userEntity = fintUserEntity.get();

        userEntity.setUserProfile(user.getUserProfile());
        userEntity.setUserNick(user.getUserNick());

        return UserDto.toUserDTO(userEntity);
    }
}
