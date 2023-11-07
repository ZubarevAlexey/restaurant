package kg.java.restaurant.domain.services;

import kg.java.restaurant.core.contracts.services.ICategoryService;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.mappers.CategoryMapper;
import kg.java.restaurant.core.models.dtos.category.*;
import kg.java.restaurant.data.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto register(CreateCategoryDto model) throws EntityDuplicateExceptions {
        var category = categoryRepository.findCategoryEntityByName(model.getName());
        if (category.isPresent()) throw new EntityDuplicateExceptions();
        var entity = categoryRepository.save(categoryMapper.fromDomain(model));
        return categoryMapper.toDomain(entity);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException, EntityDuplicateExceptions {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = category.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .build();
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        categoryRepository.deleteById(category.getId());
        return HttpStatus.OK;
    }

    @Override
    public CategoryDto getById(FindByIdCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return categoryMapper.toDomain(category);
    }
}
