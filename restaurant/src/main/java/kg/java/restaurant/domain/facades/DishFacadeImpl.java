package kg.java.restaurant.domain.facades;

import kg.java.restaurant.core.contracts.facades.IDishFacade;
import kg.java.restaurant.core.contracts.services.IDishService;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.dish.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service

public class DishFacadeImpl implements IDishFacade {
    private final IDishService dishService;

    public DishFacadeImpl(IDishService dishService) {
        this.dishService = dishService;
    }

    @Override
    public DishDto register(CreateDishDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        return dishService.register(model);
    }

    @Override
    public DishDto update(UpdateDishDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        return dishService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteDishDto model) throws EntityNotFoundException {
        return dishService.delete(model);
    }

    @Override
    public DishDto getById(FindByIdDishDto model) throws EntityNotFoundException {
        return dishService.getById(model);
    }
}
