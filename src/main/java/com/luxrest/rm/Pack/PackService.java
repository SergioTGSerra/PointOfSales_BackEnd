package com.luxrest.rm.Pack;

import com.luxrest.rm.PackProduct.PackProduct;
import com.luxrest.rm.PackProduct.PackProductDTO;
import com.luxrest.rm.Product.Product;
import com.luxrest.rm.Product.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackService {

    private final PackRepository packRepository;
    private final PackMapper packMapper;
    private final ProductRepository productRepository;

    public List<PackResponse> getAllPacks(){
        List<Pack> packs = packRepository.findAll();
        return packs.stream()
                .map(packMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PackResponse getPackById(Integer id){
        Pack pack = packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found"+ id));
        return packMapper.toDTO(pack);
    }

   @Transactional
    public List<PackResponse> getPacksByCategoryId(Integer categoryId) {
        List<Pack> packs = packRepository.findByCategory_Id(categoryId);
        if (packs.isEmpty())
            throw new EntityNotFoundException("No packs found for category ID: " + categoryId);
        return packs.stream()
                .map(packMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PackResponse createPack(PackRequest packRequest) {
        Pack pack = packMapper.toEntity(packRequest);
        Pack createdPack = packRepository.save(pack);

        List<PackProduct> packProducts = new ArrayList<>();

        for (PackProductDTO packProductDTO : packRequest.getPackLine()){
            PackProduct packProduct = new PackProduct();
            PackProduct.PackProductPK packProductPK = new PackProduct.PackProductPK();
            packProductPK.setPack(createdPack);
            Product product = productRepository.findById(packProductDTO.getProduct())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found"+ packProductDTO.getProduct()));
            packProductPK.setProduct(product);
            packProduct.setId(packProductPK);
            packProduct.setPrice(packProductDTO.getPrice());
            packProducts.add(packProduct);
        }

        createdPack.setPackLine(packProducts);
        packRepository.save(createdPack);

        return packMapper.toDTO(createdPack);
    }

    @Transactional
    public PackResponse updatePack(Integer id, PackRequest packRequest){
        packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found"+ id));
        Pack pack = packMapper.toEntity(packRequest);
        pack.setId(id);
        return packMapper.toDTO(packRepository.save(pack));
    }

    @Transactional
    public PackResponse deletePack(Integer id){
        Pack deletedPack = packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found" + id));
        deletedPack.setIsDeleted(true);
        return packMapper.toDTO(packRepository.save(deletedPack));
    }
}