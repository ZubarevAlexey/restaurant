package kg.java.restaurant.controllers.v1;

import kg.java.restaurant.core.contracts.facades.IDishFacade;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.dish.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dish")
public class DishController {

    private final IDishFacade dishFacade;

    public DishController(IDishFacade dishFacade) {
        this.dishFacade = dishFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<DishDto> register(@RequestBody CreateDishDto model){
        try {
            return ResponseEntity.ok(dishFacade.register(model));
        }
        catch (EntityDuplicateExceptions e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<DishDto> update(@RequestBody UpdateDishDto model) {
        try {
            return ResponseEntity.ok(dishFacade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteDishDto model){
        try {
            return ResponseEntity.ok(dishFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<DishDto> getById(@RequestBody FindByIdDishDto model) throws EntityNotFoundException {
        try {
            return ResponseEntity.ok(dishFacade.getById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
