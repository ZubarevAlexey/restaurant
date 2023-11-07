package kg.java.restaurant.core.models.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String phone;
}
