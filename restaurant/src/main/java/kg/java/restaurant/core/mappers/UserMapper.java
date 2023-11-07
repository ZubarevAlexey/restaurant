package kg.java.restaurant.core.mappers;

import kg.java.restaurant.core.models.dtos.user.CreateUserDto;
import kg.java.restaurant.core.models.dtos.user.UpdateUserDto;
import kg.java.restaurant.core.models.dtos.user.UserDto;
import kg.java.restaurant.core.models.entities.UserEntity;

public class UserMapper {

    public UserDto toDomain(UserEntity model){
        return UserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phone(model.getPhone())
                .build();
    }
    public UserEntity fromDomain(CreateUserDto model){
        return UserEntity.builder()
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phone(model.getPhone())
                .build();
    }
    public UserEntity fromDomain(UpdateUserDto model){
        return UserEntity.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .phone(model.getPhone())
                .build();
    }
}
