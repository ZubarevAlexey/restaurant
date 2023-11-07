package kg.java.restaurant.core.mappers;

import kg.java.restaurant.core.models.dtos.category.CategoryDto;
import kg.java.restaurant.core.models.dtos.category.CategorySearchDataDto;
import kg.java.restaurant.core.models.dtos.dish.CreateDishDto;
import kg.java.restaurant.core.models.dtos.dish.DishDto;
import kg.java.restaurant.core.models.dtos.dish.UpdateDishDto;
import kg.java.restaurant.core.models.entities.CategoryEntity;
import kg.java.restaurant.core.models.entities.DishEntity;

public class DishMapper {
    public DishDto toDomain(DishEntity model){
        var category = model.getCategory();
        return DishDto.builder()
                .id(model.getId())
                .name(model.getName())
                .coast(model.getCoast())
                .category(CategoryDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .build();
    }
    public DishEntity fromDomain(CreateDishDto model){
     return DishEntity.builder()
             .name(model.getName())
             .coast(model.getCoast())
             .build();
    }
    public DishEntity fromDomain(UpdateDishDto model){
        return DishEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .coast(model.getCoast())
                .build();
    }
}
