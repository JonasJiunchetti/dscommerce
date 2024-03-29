package com.projectcommerce.dscommerce.dto;

import com.projectcommerce.dscommerce.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CategoryDTO {

    private Long id;
    private String name;
    
    public CategoryDTO(Category entity){
        id = entity.getId();
        name = entity.getName();
    }
}
