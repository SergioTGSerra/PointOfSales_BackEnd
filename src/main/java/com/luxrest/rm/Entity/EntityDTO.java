package com.luxrest.rm.Entity;

import lombok.Data;

@Data
public class EntityDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String fiscalId;
    private String address;
    private String city;
    private String zipCode;
    private Boolean isActive;
    private Boolean isDeleted;
}