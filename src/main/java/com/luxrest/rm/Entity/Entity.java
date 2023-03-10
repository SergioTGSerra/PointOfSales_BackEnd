package com.luxrest.rm.Entity;

import com.luxrest.rm.EntityType.EntityType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name = "entities")
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String phone;

    private Long ficalId;

    private String email;

    private String address;

    private String city;

    private String zip_code;

    private boolean is_active;

    private boolean is_deleted;

    @ManyToOne
    private EntityType id_entity_type;
}