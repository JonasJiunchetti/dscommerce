package com.projectcommerce.dscommerce.DTO;

import com.projectcommerce.dscommerce.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductMinDTO {
    
   
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ProductMinDTO(Product entity){
    
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();

    }
}
