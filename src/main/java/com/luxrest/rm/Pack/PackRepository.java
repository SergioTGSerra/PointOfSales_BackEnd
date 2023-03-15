package com.luxrest.rm.Pack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackRepository extends JpaRepository<Pack, Integer> {
    List<Pack> findByIdCategory(Integer categoryId);
}