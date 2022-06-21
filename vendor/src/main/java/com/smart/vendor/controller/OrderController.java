package com.smart.vendor.controller;

import com.smart.vendor.entity.Order;
import com.smart.vendor.model.OrderDto;
import com.smart.vendor.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<String> saveProduct(@RequestBody OrderDto orderDto){
        log.info("Inside save product");
        return new ResponseEntity<>(orderService.OrderSave(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderDto>> getListOfProducts(){
        log.debug("get all products");
        return new ResponseEntity<>(orderService.getAllOrder(),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getProductsByID(@PathVariable Long id){
        log.debug("get products by ID");
        return new ResponseEntity<OrderDto>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        log.debug("delete products by Id");
        return new ResponseEntity<>(orderService.removeOrder(id),HttpStatus.OK);
    }
}
