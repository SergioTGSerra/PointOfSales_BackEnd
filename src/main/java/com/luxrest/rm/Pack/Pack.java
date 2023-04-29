package com.luxrest.rm.Pack;

import com.luxrest.rm.Category.Category;
import com.luxrest.rm.PackProduct.PackProduct;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@jakarta.persistence.Entity
@Table(name = "packs")
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer stock;

    private Boolean isActive;

    private Boolean isDeleted;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "id.pack", cascade = CascadeType.ALL)
    private List<PackProduct> packLine;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        if (this.isDeleted == null) {
            this.isDeleted = false;
        }
        if(this.isActive == null){
            this.isActive = true;
        }
    }
}