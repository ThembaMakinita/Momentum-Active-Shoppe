package com.justdev.Shoppe.core.services;

import com.justdev.Shoppe.database.entities.Customer;
import com.justdev.Shoppe.database.entities.Product;
import com.justdev.Shoppe.database.repositories.CustomerRepository;
import com.justdev.Shoppe.database.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    Logger logger = LogManager.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getAllCustomers(){
        try {
            logger.info("getAllCustomers: Retrieving List of registered Users.");
            List<Customer>customerList =customerRepository.findAll();
            logger.info("getAllCustomers: Registered User List size = "+ customerList.size());
            return customerList;
        }catch (Exception exception) {
            logger.error("getAllCustomers: Failed to get the list of Products. ",exception);
            return null;
        }

    }
}
