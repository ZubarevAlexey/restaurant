package kg.java.restaurant.core.models.dtos.dish;

import kg.java.restaurant.core.models.dtos.category.CategoryDto;
import kg.java.restaurant.core.models.dtos.user.UserDto;
import lombok.*;

import java.util.prefs.PreferencesFactory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateDishDto {
    private String name;
    private Double coast;
    private Long categoryId;

}
