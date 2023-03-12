package com.luxrest.rm.EntityType;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/entityType")
public class EntityTypeController {

    private final EntityTypeService entityTypeService;

    public EntityTypeController(EntityTypeService entityTypeService) {
        this.entityTypeService = entityTypeService;
    }

    @GetMapping
    public List<EntityType> getAllEntityTypes() {
        return entityTypeService.getAllEntityType();
    }

    @GetMapping("/{id}")
    public EntityType getEntityTypeById(@PathVariable Integer id){
        return entityTypeService.getEntityTypeById(id);
    }

    @PostMapping
    public EntityType createEntityType(@RequestBody @Valid EntityType entityType){
        return entityTypeService.createEntityType(entityType);
    }

    @PutMapping("/{id}")
    public EntityType updateEntityType(@PathVariable Integer id, @RequestBody @Valid EntityType entityType){
        return entityTypeService.updateEntityType(id, entityType);
    }

    @DeleteMapping("/{id}")
    public EntityType deleteEntityType(@PathVariable Integer id){
        return entityTypeService.deleteEntityType(id);
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
