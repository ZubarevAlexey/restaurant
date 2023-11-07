package kg.java.restaurant.core.contracts.facades;

import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;

public interface ICategoryFacade {
    CategoryDto register(CreateCategoryDto model) throws EntityDuplicateExceptions;

    CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException, EntityDuplicateExceptions;

    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;

    CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException;
}
