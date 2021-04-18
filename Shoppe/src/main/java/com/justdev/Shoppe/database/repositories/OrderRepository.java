package com.justdev.Shoppe.database.repositories;

import com.justdev.Shoppe.database.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Orders,Long> {
}
