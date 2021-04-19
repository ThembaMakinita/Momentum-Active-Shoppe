package com.justdev.Shoppe.core.services;

import com.justdev.Shoppe.core.model.OrderDTO;
import com.justdev.Shoppe.core.model.OrderRequestDto;
import com.justdev.Shoppe.database.entities.Orders;
import com.justdev.Shoppe.database.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Orders createOrder(OrderRequestDto orderDto){
        try {
           // logger.info("getAllProducts: Retrieving List of products available. ");
            Orders order = new Orders();
            order.setCustomerId(orderDto.getCustomerId());
            order.setProducts(orderDto.getProducts());
            orderRepository.save(order);
           // logger.info("getAllProducts: product List size = "+ productList.size());
            return order;
        }catch (Exception exception) {
            //logger.error("getAllProducts: Failed to get the list of Products.  ",exception);
            return null;
        }

    }
}
