package com.luxrest.rm.Tax;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public Tax getTaxById(Integer id){
        return taxRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tax not found"+ id));
    }
}
