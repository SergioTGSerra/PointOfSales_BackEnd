package com.luxrest.rm.OrderPack;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.Pack.Pack;
import com.luxrest.rm.Tax.Tax;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "order_packges")
public class OrderPack {
    @Id
    private OrderPackesPK id;

    private int quantity;

    private double price;

    @ManyToOne
    private Tax id_tax;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @PrePersist
    private void onCreate() {
        created_at = new Date();
    }

    @Data
    @Embeddable
    static class OrderPackesPK implements Serializable {

        @ManyToOne
        private Pack pack;

        @ManyToOne
        private Entity order;
    }
}