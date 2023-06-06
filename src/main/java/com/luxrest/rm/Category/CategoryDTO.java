package com.luxrest.rm.Category;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;
    private Boolean isActive;
    private Date createdAt;
}
