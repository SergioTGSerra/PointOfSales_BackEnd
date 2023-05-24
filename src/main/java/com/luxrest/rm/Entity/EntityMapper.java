package com.luxrest.rm.Entity;

import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public EntityDTO toDTO(Entity entity) {
        EntityDTO dto = new EntityDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setFiscalId(entity.getFiscalId());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setZipCode(entity.getZipCode());
        dto.setIsActive(entity.getIsActive());
        dto.setIsDeleted(entity.getIsDeleted());
        return dto;
    }

    public Entity toEntity(EntityDTO dto) {
        Entity entity = new Entity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setFiscalId(dto.getFiscalId());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setZipCode(dto.getZipCode());
        entity.setIsActive(dto.getIsActive());
        entity.setIsDeleted(dto.getIsDeleted());
        return entity;
    }
}