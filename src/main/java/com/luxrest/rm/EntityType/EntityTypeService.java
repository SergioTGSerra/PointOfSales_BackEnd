package com.luxrest.rm.EntityType;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntityTypeService {
    private final EntityTypeRepository entityTypeRepository;

    public EntityTypeService(EntityTypeRepository entityTypeRepository) {
        this.entityTypeRepository = entityTypeRepository;
    }

    public List<EntityType> getAllEntityType(){
        return entityTypeRepository.findAll();
    }

    public EntityType getEntityTypeById(Integer id){
        return entityTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity Type not found: " + id));
    }

    public EntityType createEntityType(EntityType entityType){
        return entityTypeRepository.save(entityType);
    }

    public EntityType updateEntityType(Integer id, EntityType entityType){
        EntityType existingEntityType = entityTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity Type not found"));
        existingEntityType.setName(entityType.getName());
        existingEntityType.setIsActive(entityType.getIsActive());
        return entityTypeRepository.save(existingEntityType);
    }

    public EntityType deleteEntityType(Integer id){
        EntityType deletedEntityType = entityTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
        deletedEntityType.setIsDeleted(true);
        return entityTypeRepository.save(deletedEntityType);
    }
}
