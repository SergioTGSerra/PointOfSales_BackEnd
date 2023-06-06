package com.luxrest.rm.Tax;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/taxes")
public class TaxController {
    private final TaxService taxService;

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
}
