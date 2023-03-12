package com.luxrest.rm.Tax;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/taxes")
public class TaxController {
    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping
    public List<Tax> getAllTaxes() {
        return taxService.getAllTaxes();
    }

    @GetMapping("/{id}")
    public Tax getTaxById(@PathVariable Integer id){
        return taxService.getTaxById(id);
    }

    @PostMapping
    public Tax createTax(@RequestBody @Valid Tax tax){
        return taxService.createTax(tax);
    }

    @PutMapping("/{id}")
    public Tax updateTax(@PathVariable Integer id, @RequestBody @Valid Tax tax){
        return taxService.updateTax(id, tax);
    }

    @DeleteMapping("/{id}")
    public Tax deleteTax(@PathVariable Integer id){
        return taxService.deleteTax(id);
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
