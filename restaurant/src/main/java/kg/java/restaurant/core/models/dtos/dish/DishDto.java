package kg.java.restaurant.core.models.dtos.dish;

import kg.java.restaurant.core.models.dtos.category.CategoryDto;
import kg.java.restaurant.core.models.dtos.category.CategorySearchDataDto;
import kg.java.restaurant.core.models.dtos.user.UserDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DishDto {
    private Long id;
    private String name;
    private Double coast;
    private CategoryDto category;



}
