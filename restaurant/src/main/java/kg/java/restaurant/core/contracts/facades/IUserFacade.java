package kg.java.restaurant.core.contracts.facades;

import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface IUserFacade {
    UserDto register(CreateUserDto model) throws EntityDuplicateExceptions;

    UserDto update(UpdateUserDto model) throws EntityNotFoundException, EntityDuplicateExceptions;

    HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException;

    UserDto getById(FindByIdUserDto model) throws EntityNotFoundException;
}
