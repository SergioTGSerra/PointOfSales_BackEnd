package com.luxrest.rm.Pack;

import com.luxrest.rm.PackProduct.PackProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackService {

    private final PackRepository packRepository;
    private final PackMapper packMapper;

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

        for(PackProduct packProduct : pack.getPackLine()){
            packProduct.getId().setPack(createdPack);
        }

        packRepository.save(createdPack);

        return packMapper.toDTO(createdPack);
    }

    @Transactional
    public PackResponse updatePack(Integer id, PackRequest packRequest){
        packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found"+ id));
        Pack pack = packMapper.toEntity(packRequest);

        for(PackProduct packProduct : pack.getPackLine()){
            packProduct.getId().setPack(pack);
        }

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