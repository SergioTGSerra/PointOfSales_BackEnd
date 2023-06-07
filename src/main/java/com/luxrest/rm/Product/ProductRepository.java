package com.luxrest.rm.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Integer categoryId);

    List<Product> findByIsDeletedFalse();

    List<Product> findByTaxId(Integer id);
}