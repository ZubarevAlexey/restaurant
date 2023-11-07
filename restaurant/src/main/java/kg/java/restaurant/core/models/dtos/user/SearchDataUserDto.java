package kg.java.restaurant.core.models.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class SearchDataUserDto {
    private String firstName;
    private String lastName;
}
