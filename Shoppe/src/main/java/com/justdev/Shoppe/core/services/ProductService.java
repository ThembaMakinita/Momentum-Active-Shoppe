package com.justdev.Shoppe.core.services;

import com.justdev.Shoppe.database.entities.Customer;
import com.justdev.Shoppe.database.entities.Product;
import com.justdev.Shoppe.database.repositories.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> getAllProducts(){
        try {
            logger.info("getAllProducts: Retrieving List of products available. ");
            List<Product>productList =productRepository.findAll();
            logger.info("getAllProducts: product List size = "+ productList.size());
            return productList;
        }catch (Exception exception) {
            logger.error("getAllProducts: Failed to get the list of Products.  ",exception);
            return null;
        }

    }


    @Transactional
    public Optional<Product> getProduct(long productId){
        try {
            logger.info("getProduct: Retrieving selected product.");
            Optional<Product> product = productRepository.findById(productId);
            logger.info("getCustomers: Product found = "+ product.toString());
            return product;
        }catch (Exception exception) {
            logger.error("getCustomers: Failed to get the specified Customer ",exception);
            return null;
        }

    }

}
