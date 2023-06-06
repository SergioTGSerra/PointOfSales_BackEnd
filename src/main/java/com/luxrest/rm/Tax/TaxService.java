package com.luxrest.rm.Tax;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaxService {
    private final TaxRepository taxRepository;
    public List<Tax> getAllTaxes(){
        return taxRepository.findByIsDeletedFalse();
    }
    @Transactional
    public Tax getTaxById(Integer id){
        return taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found: "+ id));
    }
    @Transactional
    public Tax createTax(Tax tax){
        if(tax.getId() != null)
            throw new IllegalArgumentException("You cannot pass the id parameter in the request!");
        tax.setIsDeleted(false);
        return taxRepository.save(tax);
    }
    @Transactional
    public Tax updateTax(Integer id, Tax tax){
        Tax existingTax = taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"));

        existingTax.setValue(tax.getValue());

        return taxRepository.save(tax);
    }
    @Transactional
    public Tax deleteTax(Integer id){
        Tax deletedTax = taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"));
        deletedTax.setIsDeleted(true);
        return taxRepository.save(deletedTax);
    }
}
