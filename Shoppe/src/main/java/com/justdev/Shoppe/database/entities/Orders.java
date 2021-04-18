package com.justdev.Shoppe.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private long orderId;

    @Column(name="fk_CustomerId")
    private long customerId;

    @ManyToMany
    @JoinTable(name = "Ordered_Products",
            joinColumns        = @JoinColumn(name = "OrderId"),
            inverseJoinColumns = @JoinColumn(name="productId"))
    private List<Product> products;

    private int quantity;

    @Override
    public String toString() {
        return "Orders Entity{" +
                "Order Id = " + orderId +
                ", Customer Id = " + customerId +
                ", Products = " + products +
                ", Quantity = " + quantity +
                '}';
    }
}
