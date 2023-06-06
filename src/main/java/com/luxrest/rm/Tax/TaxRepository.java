package com.luxrest.rm.Tax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {
    List<Tax> findByIsDeletedFalse();
}