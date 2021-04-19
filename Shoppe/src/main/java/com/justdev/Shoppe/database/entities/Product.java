package com.justdev.Shoppe.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private long productId;
    @Column(name = "Code" ,length = 50)
    private String productCode;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name ="Point_Price")
    private int pointPrice;




}
