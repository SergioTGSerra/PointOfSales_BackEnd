package com.luxrest.rm.Pack;

import com.luxrest.rm.Category.CategoryService;
import com.luxrest.rm.PackProduct.PackProduct;
import com.luxrest.rm.PackProduct.PackProductDTO;
import com.luxrest.rm.Product.ProductMapper;
import com.luxrest.rm.Product.ProductRepository;
import com.luxrest.rm.Product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PackMapper {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    public PackResponse toDTO(Pack pack){
        PackResponse packResponse = new PackResponse();
        packResponse.setId(pack.getId());
        packResponse.setName(pack.getName());
        packResponse.setStock(pack.getStock());
        packResponse.setIsActive(pack.getIsActive());
        packResponse.setCategory(String.valueOf(pack.getCategory().getName()));
//        packResponse.setPackLine(pack.getPackLine());
        return packResponse;
    }

    public Pack toEntity(PackRequest packRequest){
        Pack pack = new Pack();
        pack.setName(packRequest.getName());
        pack.setStock(packRequest.getStock());
        pack.setIsActive(packRequest.getIsActive());
        pack.setCategory(categoryService.getCategoryById(packRequest.getCategory()));
        return pack;
    }
}
