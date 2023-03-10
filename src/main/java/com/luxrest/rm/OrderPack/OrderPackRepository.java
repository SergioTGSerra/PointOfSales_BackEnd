package com.luxrest.rm.OrderPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPackRepository extends JpaRepository<OrderPack, OrderPack.OrderPackesPK> {
}