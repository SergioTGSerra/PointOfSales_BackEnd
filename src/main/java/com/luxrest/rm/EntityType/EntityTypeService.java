package com.luxrest.rm.EntityType;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EntityTypeService {
    private final EntityTypeRepository entityTypeRepository;

    public List<EntityType> getAllEntityType(){
        return entityTypeRepository.findAll();
    }

    public EntityType getEntityTypeById(Integer id){
        return entityTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity Type not found: " + id));
    }

    public EntityType createEntityType(EntityType entityType){
        if(entityType.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        return entityTypeRepository.save(entityType);
    }

    public EntityType updateEntityType(Integer id, EntityType entityType){
        entityTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity Type not found"));
        entityType.setId(id);
        return entityTypeRepository.save(entityType);
    }

    public EntityType deleteEntityType(Integer id){
        EntityType deletedEntityType = entityTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
        deletedEntityType.setIsDeleted(true);
        return entityTypeRepository.save(deletedEntityType);
    }
}
