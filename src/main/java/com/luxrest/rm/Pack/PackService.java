package com.luxrest.rm.Pack;

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

    public List<PackDTO> getAllPacks(){
        List<Pack> packs = packRepository.findAll();
        return packs.stream()
                .map(packMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PackDTO getPackById(Integer id){
        Pack pack = packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found"+ id));
        return packMapper.toDTO(pack);
    }

   @Transactional
    public List<PackDTO> getPacksByCategoryId(Integer categoryId) {
        List<Pack> packs = packRepository.findByCategory_Id(categoryId);
        if (packs.isEmpty())
            throw new EntityNotFoundException("No packs found for category ID: " + categoryId);
        return packs.stream()
                .map(packMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PackDTO createPack(PackDTO packDTO) {
        if(packDTO.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        Pack pack = packMapper.toEntity(packDTO);
        return packMapper.toDTO(packRepository.save(pack));
    }

    @Transactional
    public PackDTO updatePack(Integer id, PackDTO packDTO){
        packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found"+ id));
        Pack pack = packMapper.toEntity(packDTO);
        pack.setId(id);
        return packMapper.toDTO(packRepository.save(pack));
    }

    @Transactional
    public PackDTO deletePack(Integer id){
        Pack deletedPack = packRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pack not found" + id));
        deletedPack.setIsDeleted(true);
        return packMapper.toDTO(packRepository.save(deletedPack));
    }
}