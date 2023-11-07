package kg.java.restaurant.domain.facades;

import kg.java.restaurant.core.contracts.facades.IUserFacade;
import kg.java.restaurant.core.contracts.services.IUserService;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserFacade implements IUserFacade {
    private final IUserService userService;

    public UserFacade(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto register(CreateUserDto model) throws EntityDuplicateExceptions {
        return userService.register(model);
    }

    @Override
    public UserDto update(UpdateUserDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        return userService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteUserDto model) throws EntityNotFoundException {
        return userService.delete(model);
    }

    @Override
    public UserDto getById(FindByIdUserDto model) throws EntityNotFoundException {
        return userService.getById(model);
    }
}
