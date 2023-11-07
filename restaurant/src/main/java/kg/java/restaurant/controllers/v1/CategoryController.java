package kg.java.restaurant.controllers.v1;

import kg.java.restaurant.core.contracts.facades.ICategoryFacade;
import kg.java.restaurant.core.exceptions.EntityDuplicateExceptions;
import kg.java.restaurant.core.exceptions.EntityNotFoundException;
import kg.java.restaurant.core.models.dtos.category.*;
import kg.java.restaurant.core.models.dtos.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryFacade categoryFacade;

    public CategoryController(ICategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryDto> register(@RequestBody CreateCategoryDto model){
        try {
            return ResponseEntity.ok(categoryFacade.register(model));
        }
        catch (EntityDuplicateExceptions e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<CategoryDto> update(@RequestBody UpdateCategoryDto model) {
        try {
            return ResponseEntity.ok(categoryFacade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteCategoryDto model){
        try {
            return ResponseEntity.ok(categoryFacade.delete(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<CategoryDto> getById(@RequestBody FindByIdCategoryDto model) throws EntityNotFoundException {
        try {
            return ResponseEntity.ok(categoryFacade.getById(model));
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
