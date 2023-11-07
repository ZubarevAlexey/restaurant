package kg.java.restaurant.core.models.dtos.user;

import kg.java.restaurant.core.models.dtos.base.BaseDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateUserDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String phone;
}
