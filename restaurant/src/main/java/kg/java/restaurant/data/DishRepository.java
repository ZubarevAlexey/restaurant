package kg.java.restaurant.data;

import kg.java.restaurant.core.models.entities.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long> {
    Optional<DishEntity> findDishEntityByName(String name);
}
