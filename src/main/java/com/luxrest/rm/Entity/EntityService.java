package com.luxrest.rm.Entity;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EntityService {
    private final EntityRepository entityRepository;

    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Transactional
    public Entity getEntityById(Long id){
        Entity entity = entityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"+ id));
        return entity;
    }

}
