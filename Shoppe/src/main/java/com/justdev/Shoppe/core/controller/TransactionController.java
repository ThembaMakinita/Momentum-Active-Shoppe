package com.justdev.Shoppe.core.controller;

import com.justdev.Shoppe.commons.converters.BeanConverter;
import com.justdev.Shoppe.core.model.CustomerDTO;
import com.justdev.Shoppe.core.model.OrderDTO;
import com.justdev.Shoppe.core.model.OrderRequestDto;
import com.justdev.Shoppe.core.model.ProductDTO;
import com.justdev.Shoppe.core.services.CustomerService;
import com.justdev.Shoppe.core.services.OrderService;
import com.justdev.Shoppe.core.services.ProductService;
import com.justdev.Shoppe.database.entities.Customer;
import com.justdev.Shoppe.database.entities.Orders;
import com.justdev.Shoppe.database.entities.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class TransactionController {

    private Logger logger = LogManager.getLogger(TransactionController.class);

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

    @GetMapping("/viewAllAvailableProducts/{userID}")
    public ResponseEntity getAllCustomers(@PathVariable(value = "userID")int userID){
        Optional<Customer> customer = costomersService.getCustomers(userID);
        System.out.println(customer.toString());
        if(!customer.isPresent())
            return new ResponseEntity<>("Exception Occurred: Unable to find the customer with ID : " + userID, HttpStatus.BAD_REQUEST);

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


    @PostMapping("/placeOrder")
    public ResponseEntity createOrder (@RequestBody OrderRequestDto orderRequestDTO) {

        int totalCost = 0;
        Optional<Customer> customer = costomersService.getCustomers(orderRequestDTO.getCustomerId());
        System.out.println(customer.toString());
        if(!customer.isPresent())
            return new ResponseEntity<>("Exception Occurred: Unable to find the customer with ID : " + orderRequestDTO.getCustomerId(), HttpStatus.BAD_REQUEST);

        if(orderRequestDTO.getProducts().size()>0){
            for(Product product: orderRequestDTO.getProducts()){
                Optional<Product> dbProduct = productService.getProduct(product.getProductId());
                if(!dbProduct.isPresent()){
                    return new ResponseEntity<>("Exception Occurred: Unable to find the Product with productID of : " + product.getProductId(), HttpStatus.BAD_REQUEST);
                }
                else {
                    totalCost = +product.getPointPrice();
                }
            }
        }
        if(customer.get().getActivePoints() < totalCost ){
            return new ResponseEntity<>("Exception Occurred: Customer Doesnt have enough points to purchase products " , HttpStatus.BAD_REQUEST);
        }
        else {
            customer.get().setActivePoints(customer.get().getActivePoints() - totalCost);
            costomersService.updateCustomer(customer.get());
            Optional<Orders> order = Optional.ofNullable(orderService.createOrder(orderRequestDTO));
            return new ResponseEntity<>(order, HttpStatus.OK);
        }

    }

}
