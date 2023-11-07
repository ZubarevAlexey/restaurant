package kg.java.restaurant.core.mappers.base;

import kg.java.restaurant.core.mappers.CategoryMapper;
import kg.java.restaurant.core.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public UserMapper buildUserMapper(){
        return new UserMapper();
    }
    @Bean
    public CategoryMapper buildCategoryMapper(){
        return new CategoryMapper();
    }
}
