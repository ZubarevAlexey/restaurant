package kg.java.restaurant.domain.services;

import kg.java.restaurant.core.contracts.services.IDishService;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.mappers.DishMapper;
import kg.java.restaurant.core.models.dtos.dish.*;
import kg.java.restaurant.data.CategoryRepository;
import kg.java.restaurant.data.DishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DishServiceImpl implements IDishService {
    private final DishMapper dishMapper;
    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;

    public DishServiceImpl(DishMapper dishMapper, DishRepository dishRepository, CategoryRepository categoryRepository) {
        this.dishMapper = dishMapper;
        this.dishRepository = dishRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DishDto register(CreateDishDto model) throws EntityDuplicateExceptions, EntityNotFoundException {
        var dish = dishRepository.findDishEntityByName(model.getName()).orElseThrow(EntityDuplicateExceptions::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var entity = dishMapper.fromDomain(model);
        entity.setCategory(category);
        entity = dishRepository.save(entity);
        return dishMapper.toDomain(entity);
    }

    @Override
    public DishDto update(UpdateDishDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var dish = dishRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var entity = dish.toBuilder()
                .name(model.getName())
                .coast(model.getCoast())
                .category(category)
                .build();
        entity = dishRepository.save(entity);
        return dishMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteDishDto model) throws EntityNotFoundException {
        var dish = dishRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        dishRepository.deleteById(dish.getId());
        return HttpStatus.OK;
    }

    @Override
    public DishDto getById(FindByIdDishDto model) throws EntityNotFoundException {
        var dish = dishRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return dishMapper.toDomain(dish);
    }
}
