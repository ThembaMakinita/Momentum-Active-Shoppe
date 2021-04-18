package com.justdev.Shoppe.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer")
@Data
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private long customerId;


    @Column(name = "Name", length = 50)
    private String name;

    @Override
    public String toString() {
        return "Customer{" +
                "Id =" + customerId +
                ", Name ='" + name + '\'' +
                '}';
    }
}
