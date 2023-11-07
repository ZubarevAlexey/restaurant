package kg.java.restaurant.core.models.dtos.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
}
