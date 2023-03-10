package com.luxrest.rm.Point;

import com.luxrest.rm.Entity.Entity;
import com.luxrest.rm.Order.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@jakarta.persistence.Entity
@Table(name = "points")
public class Point {
    @Id
    private PointsPk id;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    @Data
    @Embeddable
    static class PointsPk implements Serializable {

        @ManyToOne
        private Order order;

        @ManyToOne
        private Entity entity;
    }
}