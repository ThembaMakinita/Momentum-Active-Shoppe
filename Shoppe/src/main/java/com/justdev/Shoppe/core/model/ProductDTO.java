package com.justdev.Shoppe.core.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long productId;
    private String productCode;
    private String name;
    private double pointPrice;

}
