package kg.java.restaurant.core.contracts.facades;

import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.dish.*;
import kg.java.restaurant.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface IDishFacade {
    DishDto register(CreateDishDto model) throws EntityDuplicateExceptions, EntityNotFoundException;

    DishDto update(UpdateDishDto model) throws EntityNotFoundException, EntityDuplicateExceptions;

    HttpStatus delete(DeleteDishDto model) throws EntityNotFoundException;

    DishDto getById(FindByIdDishDto model) throws EntityNotFoundException;
}
