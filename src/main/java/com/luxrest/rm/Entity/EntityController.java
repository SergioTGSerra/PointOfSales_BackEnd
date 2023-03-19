package com.luxrest.rm.Entity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/entities")
@AllArgsConstructor
public class EntityController {

    private final EntityService entityService;

    @GetMapping
    public List<Entity> getAllEntities() {
        return entityService.getAllEntities();
    }

    @GetMapping("/{id}")
    public Entity getEntitiesById(@PathVariable Long id){
        return entityService.getEntityById(id);
    }

    @PostMapping
    public Entity createEntityType(@RequestBody @Valid Entity entityType){
        return entityService.createEntity(entityType);
    }

    @PutMapping("/{id}")
    public Entity updateEntity(@PathVariable Long id, @RequestBody @Valid Entity entity){
        return entityService.updateEntity(id, entity);
    }

    @DeleteMapping("/{id}")
    public Entity deleteEntityType(@PathVariable Long id){
        return entityService.deleteEntity(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
