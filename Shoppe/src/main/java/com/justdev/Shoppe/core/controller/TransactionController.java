package com.justdev.Shoppe.core.controller;

import com.justdev.Shoppe.commons.converters.BeanConverter;
import com.justdev.Shoppe.core.model.CustomerDTO;
import com.justdev.Shoppe.core.model.ProductDTO;
import com.justdev.Shoppe.core.services.CustomerService;
import com.justdev.Shoppe.core.services.OrderService;
import com.justdev.Shoppe.core.services.ProductService;
import com.justdev.Shoppe.database.entities.Customer;
import com.justdev.Shoppe.database.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class TransactionController {

    @Autowired
    private CustomerService costomersService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BeanConverter beanConverter;

    @GetMapping("/getAllRegisteredUsers")
    public ResponseEntity getAllCustomers(){
        List<Customer> customers = costomersService.getAllCustomers();
        if(customers == null)
            return new ResponseEntity<>("Exception Occurred: Unable to find the list of Customers", HttpStatus.BAD_REQUEST);

            List<CustomerDTO> responseDTO = beanConverter.mapList(customers,CustomerDTO.class);
            if(responseDTO != null && responseDTO.size() > 0 ){
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No Results Found For Customer List", HttpStatus.NOT_FOUND);
            }
    }

    @GetMapping("/viewAllAvailableProducts/{UserID}")
    public ResponseEntity getAllCustomers(@PathVariable(value = "UserID")int UserID){
        List<Product> productList = productService.getAllProducts();
        if(productList == null)
            return new ResponseEntity<>("Exception Occurred: Unable to find the list of Products", HttpStatus.BAD_REQUEST);

        List<ProductDTO> responseDTO = beanConverter.mapList(productList, ProductDTO.class);
        if(responseDTO != null && responseDTO.size() > 0 ){
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Results Found For Product List", HttpStatus.NOT_FOUND);
        }
    }
}
