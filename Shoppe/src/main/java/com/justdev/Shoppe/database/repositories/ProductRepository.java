package com.justdev.Shoppe.database.repositories;

import com.justdev.Shoppe.database.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository  extends JpaRepository <Product,Long> {

}
