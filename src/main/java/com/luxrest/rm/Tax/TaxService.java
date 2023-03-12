package com.luxrest.rm.Tax;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {
    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public List<Tax> getAllTaxes(){
        return taxRepository.findAll();
    }

    public Tax getTaxById(Integer id){
        return taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found: "+ id));
    }

    public Tax createTax(Tax tax){
        if(tax.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        tax.setIsDeleted(false);
        return taxRepository.save(tax);
    }

    public Tax updateTax(Integer id, Tax tax){
        Tax updatedTax = taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
        updatedTax.setName(tax.getName());
        updatedTax.setTax(tax.getTax());
        updatedTax.setIsDeleted(false);
        return taxRepository.save(updatedTax);
    }

    public Tax deleteTax(Integer id){
        Tax deletedTax = taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
        deletedTax.setIsDeleted(true);
        return taxRepository.save(deletedTax);
    }
}
