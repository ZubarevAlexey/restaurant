package kg.java.restaurant.core.models.dtos.category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CategoryDto {
    private Long id;
    private String name;
}
