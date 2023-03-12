package com.luxrest.rm.Tax;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@jakarta.persistence.Entity
@Table(name = "tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Tax is mandatory")
    private Double tax;

    private Boolean isDeleted;
}