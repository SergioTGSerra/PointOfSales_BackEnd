package com.luxrest.rm.Entity;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {
    private final EntityRepository entityRepository;

    public List<Entity> getAllEntities(){
        return entityRepository.findAll();
    }

    public Entity getEntityById(Long id){
        return entityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found: " + id));
    }

    public Entity createEntity(Entity entity){
        if(entity.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        return entityRepository.save(entity);
    }

    public Entity updateEntity(Long id, Entity entity){
        entityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        entity.setId(id);
        return entityRepository.save(entity);
    }

    public Entity deleteEntity(Long id){
        Entity deletedEntity = entityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        deletedEntity.setIsDeleted(true);
        return entityRepository.save(deletedEntity);
    }

    public Entity getLoggedEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return entityRepository.findById(((Entity) authentication.getPrincipal()).getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found: " + ((Entity) authentication.getPrincipal()).getId()));
    }
}
