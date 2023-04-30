package com.luxrest.rm.Pack;

import com.luxrest.rm.Category.CategoryService;
import com.luxrest.rm.PackProduct.PackProduct;
import com.luxrest.rm.PackProduct.PackProductDTO;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
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

        List<PackProductDTO> packProducts = new ArrayList<>();

        for (PackProduct packProduct : pack.getPackLine()){
            PackProductDTO packProductDTO = new PackProductDTO();
            packProductDTO.setProduct(packProduct.getId().getProduct().getId());
            packProductDTO.setPrice(packProduct.getPrice());
            packProducts.add(packProductDTO);
        }

        packResponse.setPackLine(packProducts);

        return packResponse;
    }

    public Pack toEntity(PackRequest packRequest){
        Pack pack = new Pack();
        pack.setName(packRequest.getName());
        pack.setStock(packRequest.getStock());
        pack.setIsActive(packRequest.getIsActive());
        pack.setCategory(categoryService.getCategoryById(packRequest.getCategory()));

        List<PackProduct> packProducts = new ArrayList<>();

        for (PackProductDTO packProductDTO : packRequest.getPackLine()){
            PackProduct packProduct = new PackProduct();
            PackProduct.PackProductPK packProductPK = new PackProduct.PackProductPK();
            Product product = productRepository.findById(packProductDTO.getProduct())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"+ packProductDTO.getProduct()));
            packProductPK.setProduct(product);
            packProduct.setId(packProductPK);
            packProduct.setPrice(packProductDTO.getPrice());
            packProducts.add(packProduct);
        }

        pack.setPackLine(packProducts);


        return pack;
    }
}
