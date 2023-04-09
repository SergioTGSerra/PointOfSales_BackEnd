package com.luxrest.rm.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntityRepository extends JpaRepository<Entity, Long> {
    Optional<Entity> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
