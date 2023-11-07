package kg.java.restaurant.core.models.dtos.dish;

import kg.java.restaurant.core.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateDishDto extends BaseDto {
    private String name;
    private Double coast;
    private Long categoryId;

}
