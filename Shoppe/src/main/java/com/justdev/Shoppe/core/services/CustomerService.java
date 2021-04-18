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
import java.util.Optional;

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

    @Transactional
    public Optional<Customer> getCustomers(long userid){
        try {
            logger.info("getCustomers: Retrieving registered Customer by ID.");
            Optional<Customer> customer = customerRepository.findById(userid);
            logger.info("getCustomers: Registered User  = "+ customer.toString());
            return customer;
        }catch (Exception exception) {
            logger.error("getCustomers: Failed to get the specified Customer ",exception);
            return null;
        }

    }
}
