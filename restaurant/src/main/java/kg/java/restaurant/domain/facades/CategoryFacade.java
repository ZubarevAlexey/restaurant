package kg.java.restaurant.domain.facades;

import kg.java.restaurant.core.contracts.facades.ICategoryFacade;
import kg.java.restaurant.core.contracts.services.ICategoryService;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.category.*;
import kg.java.restaurant.domain.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryFacade implements ICategoryFacade {
    private final ICategoryService categoryService;

    public CategoryFacade(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto register(CreateCategoryDto model) throws EntityDuplicateExceptions {
        return categoryService.register(model);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        return categoryService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        return categoryService.delete(model);
    }

    @Override
    public CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException {
        return categoryService.getById(model);
    }
}
