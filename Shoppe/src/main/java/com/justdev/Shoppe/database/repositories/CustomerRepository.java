package com.justdev.Shoppe.database.repositories;

import com.justdev.Shoppe.database.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
