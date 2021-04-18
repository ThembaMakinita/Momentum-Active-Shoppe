package com.justdev.Shoppe.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private long customerId;
    @Column(name = "Code")
    private String productCode;
    @Column(name = "Name", length = 50)
    private String name;

    @Override
    public String toString() {
        return "Product{" +
                "Customer Id=" + customerId +
                ", Product Code='" + productCode + '\'' +
                ", Product Name='" + name + '\'' +
                '}';
    }
}
