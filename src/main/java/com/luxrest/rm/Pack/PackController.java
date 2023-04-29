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
    public ResponseEntity<List<PackResponse>> getAllPacks(){
        return ResponseEntity.ok(packService.getAllPacks());
    }

    @GetMapping("/{id}")
    public PackResponse getPackById(@PathVariable Integer id){
        return packService.getPackById(id);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<PackResponse>> getPacksByIdCategory(@PathVariable Integer id){
        return ResponseEntity.ok(packService.getPacksByCategoryId(id));
    }

    @PostMapping
    public ResponseEntity<PackResponse> createPack(@RequestBody @Valid PackRequest packRequest) {
        return ResponseEntity.ok(packService.createPack(packRequest));
    }

    @PutMapping("/{id}")
    public PackResponse updatePack(@PathVariable Integer id, @RequestBody @Valid PackRequest packRequest){
        return packService.updatePack(id, packRequest);
    }

    @DeleteMapping("/{id}")
    public PackResponse deletePack(@PathVariable Integer id){
        return packService.deletePack(id);
    }
}
