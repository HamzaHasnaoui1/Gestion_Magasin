package org.example.gestion_magasin.Security.mappers;

import org.example.gestion_magasin.Security.dtos.UserDto;
import org.example.gestion_magasin.Security.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto ToUserDto(User user);
    User ToUserEntity(UserDto userDto);
}
