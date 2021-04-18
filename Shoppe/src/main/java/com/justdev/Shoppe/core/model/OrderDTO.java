package com.justdev.Shoppe.core.model;

import com.justdev.Shoppe.database.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private long OrderId;
    private long customerId;
    private List<Product> products;
    private int quantity;

}
