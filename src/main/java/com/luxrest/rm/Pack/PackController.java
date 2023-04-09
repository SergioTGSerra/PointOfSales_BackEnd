package com.luxrest.rm.Pack;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packs")
@AllArgsConstructor
public class PackController {

    private final PackService packService;

    @GetMapping
    public ResponseEntity<List<PackDTO>> getAllPacks(){
        return ResponseEntity.ok(packService.getAllPacks());
    }

    @GetMapping("/{id}")
    public PackDTO getPackById(@PathVariable Integer id){
        return packService.getPackById(id);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<PackDTO>> getPacksByIdCategory(@PathVariable Integer id){
        return ResponseEntity.ok(packService.getPacksByCategoryId(id));
    }

    @PostMapping
    public ResponseEntity<PackDTO> createPack(@RequestBody @Valid PackDTO packDTO) {
        return ResponseEntity.ok(packService.createPack(packDTO));
    }

    @PutMapping("/{id}")
    public PackDTO updatePack(@PathVariable Integer id, @RequestBody @Valid PackDTO packDTO){
        return packService.updatePack(id, packDTO);
    }

    @DeleteMapping("/{id}")
    public PackDTO deletePack(@PathVariable Integer id){
        return packService.deletePack(id);
    }
}
