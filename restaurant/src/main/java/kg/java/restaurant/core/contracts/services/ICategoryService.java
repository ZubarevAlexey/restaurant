package kg.java.restaurant.core.contracts.services;

import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.category.*;
import kg.java.restaurant.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;

public interface ICategoryService {
    CategoryDto register(CreateCategoryDto model) throws EntityDuplicateExceptions;

    CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException, EntityDuplicateExceptions;

    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;

    CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException;
}
