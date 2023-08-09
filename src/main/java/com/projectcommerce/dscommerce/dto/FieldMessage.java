package com.projectcommerce.dscommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FieldMessage {
    
    private String fieldName;

    private String message;
}
