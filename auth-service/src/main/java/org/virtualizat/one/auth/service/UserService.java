package org.virtualizat.one.auth.service;

import org.virtualizat.one.auth.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    public ServiceResponse<UserDto> createUser(UserDto createUser);

    public ServiceResponse<UserDto> updateUser(String id, UserDto updateUser);
    public ServiceResponse<UserDto> deleteUser(String id);

    public ServiceResponse<List<UserDto>> getUsers();
    public ServiceResponse<UserDto> getUser(String id);
}
