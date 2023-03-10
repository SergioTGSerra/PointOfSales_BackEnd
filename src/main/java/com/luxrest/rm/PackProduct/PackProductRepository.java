package com.luxrest.rm.PackProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackProductRepository extends JpaRepository<PackProduct, PackProduct.PackProductPK> {
}
