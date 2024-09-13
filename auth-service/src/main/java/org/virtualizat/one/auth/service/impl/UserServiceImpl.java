package org.virtualizat.one.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtualizat.one.auth.dto.UserDto;
import org.virtualizat.one.auth.entity.UserEntity;
import org.virtualizat.one.auth.entity.emun.State;
import org.virtualizat.one.auth.mapper.UserMapper;
import org.virtualizat.one.auth.repository.UserRepository;
import org.virtualizat.one.auth.service.ServiceResponse;
import org.virtualizat.one.auth.service.UserService;
import org.virtualizat.one.auth.service.util.MessageCode;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public ServiceResponse<UserDto> createUser(UserDto createUser) {

        UserEntity newUser = userMapper.toEntity(createUser);

        Optional<UserEntity> existingUser = userRepository.findByUsername(newUser.getUsername());

        if (existingUser.isPresent()) {
            return new ServiceResponseImpl<>(MessageCode.ALREADY_EXISTS, userMapper.toDto(existingUser.get()));
        }else{
            newUser.setState(State.INACTIVATED);
            UserEntity savedUser = userRepository.save(newUser);
            return new ServiceResponseImpl<>(MessageCode.CREATED, userMapper.toDto(savedUser));
        }
    }

    @Override
    public ServiceResponse<UserDto> updateUser(String id, UserDto updateUser) {

        Optional<UserEntity> existingUser = userRepository.findById(UUID.fromString(id));

        if (existingUser.isEmpty()) {
            return new ServiceResponseImpl<>(MessageCode.NOT_FOUND, userMapper.toDto(existingUser.get()));
        }else{
            UserEntity updatedUser = existingUser.get();
            updatedUser.setUsername(updatedUser.getUsername());
            updatedUser.setPassword(updateUser.getPassword());
            updatedUser.setHashtag(updateUser.getHashtag());
            updatedUser.setState(State.valueOf(updateUser.getState()));

            return new ServiceResponseImpl<>(MessageCode.UPDATED, userMapper.toDto(userRepository.save(updatedUser)));
        }
    }

    @Override
    public ServiceResponse<UserDto> deleteUser(String id) {
        Optional<UserEntity> existingUser = userRepository.findById(UUID.fromString(id));

        if (existingUser.isEmpty()) {
            return new ServiceResponseImpl<>(MessageCode.NOT_FOUND, userMapper.toDto(existingUser.get()));
        }else{
            UserEntity updatedUser = existingUser.get();
            updatedUser.setState(State.DELETED);

            return new ServiceResponseImpl<>(MessageCode.DELETED, userMapper.toDto(userRepository.save(updatedUser)));
        }
    }

    @Override
    public ServiceResponse<List<UserDto>> getUsers() {
        return new ServiceResponseImpl<>(MessageCode.FOUND, userMapper.toCollectionDto(userRepository.findAll()));
    }

    @Override
    public ServiceResponse<UserDto> getUser(String id) {
        Optional<UserEntity> existingUser = userRepository.findById(UUID.fromString(id));

        if (existingUser.isPresent()) {
            return new ServiceResponseImpl<>(MessageCode.FOUND, userMapper.toDto(existingUser.get()));
        }else{
            return new ServiceResponseImpl<>(MessageCode.NOT_FOUND, userMapper.toDto(existingUser.get()));
        }
    }
}
