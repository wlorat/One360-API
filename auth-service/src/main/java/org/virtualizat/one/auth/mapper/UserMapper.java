package org.virtualizat.one.auth.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.virtualizat.one.auth.dto.UserDto;
import org.virtualizat.one.auth.entity.UserEntity;
import org.virtualizat.one.auth.entity.emun.State;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class UserMapper {

    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userDto.getUsername());
            userEntity.setPassword(userDto.getPassword());
            userEntity.setHashtag(userDto.getHashtag());
            userEntity.setState(State.valueOf(userDto.getState()));
        return userEntity;
    }

    public List<UserEntity> toCollectionModel(List<UserDto> users) {
        return users.stream()
                .map(this::toEntity)
                .toList();
    }

    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
            userDto.setId(userEntity.getId().toString());
            userDto.setUsername(userEntity.getUsername());
            userDto.setPassword(userEntity.getPassword());
            userDto.setHashtag(userEntity.getHashtag());
            userDto.setState(userEntity.getState().name());
        return userDto;

    }

    public List<UserDto> toCollectionDto(List<UserEntity> users) {
        return users.stream()
                .map(this::toDto)
                .toList();
    }
}
