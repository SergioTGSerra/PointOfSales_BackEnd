package com.luxrest.rm.Pack;

import com.luxrest.rm.Category.CategoryService;
import com.luxrest.rm.Tax.TaxService;
import org.springframework.stereotype.Component;

@Component
public class PackMapper {

    private final CategoryService categoryService;

    private final TaxService taxService;

    public PackMapper(CategoryService categoryService, TaxService taxService) {
        this.categoryService = categoryService;
        this.taxService = taxService;
    }

    public PackDTO toDTO(Pack pack){
        PackDTO packDTO = new PackDTO();
        packDTO.setId(pack.getId());
        packDTO.setName(pack.getName());
        packDTO.setStock(pack.getStock());
        packDTO.setPrice(pack.getPrice());
        packDTO.setIs_active(pack.getIsActive());
        packDTO.setIs_deleted(pack.getIsDeleted());
        packDTO.setIdCategory(pack.getIdCategory().getId());
        packDTO.setIdTax(pack.getIdTax().getId());
        return packDTO;
    }

    public Pack toEntity(PackDTO packDTO){
        Pack pack = new Pack();
        pack.setName(packDTO.getName());
        pack.setStock(packDTO.getStock());
        pack.setPrice(packDTO.getPrice());
        pack.setIsActive(packDTO.getIs_active());
        pack.setIsDeleted(packDTO.getIs_deleted());
        pack.setIdCategory(categoryService.getCategoryById(packDTO.getIdCategory()));
        pack.setIdTax(taxService.getTaxById(packDTO.getIdTax()));
        return pack;
    }
}
