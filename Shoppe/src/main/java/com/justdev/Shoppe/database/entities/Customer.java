package com.justdev.Shoppe.database.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId")
    private long customerId;


    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Active_Points")
    private long activePoints;


    @Override
    public String toString() {
        return "Customer Entity {" +
                "Id =" + customerId +
                ", Name ='" + name + '\'' +
                '}';
    }
}
