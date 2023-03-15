package com.luxrest.rm.Pack;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/packs")
public class PackController {

    private final PackService packService;

    public PackController(PackService packService) {
        this.packService = packService;
    }

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
