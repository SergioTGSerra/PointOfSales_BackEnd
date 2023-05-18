package com.luxrest.rm.Entity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/logged")
    public Entity getLoggedEntity(){
        return entityService.getLoggedEntity();
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

}
