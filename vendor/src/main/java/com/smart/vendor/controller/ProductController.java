package com.smart.vendor.controller;

import com.smart.vendor.entity.Product;
import com.smart.vendor.model.ProductDto;
import com.smart.vendor.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

   @Autowired
   private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto){
        log.info("Inside save product");
        return new ResponseEntity<String>(productService.productSave(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>>getListOfProducts(){
        log.debug("Get all products");
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductsByID(@PathVariable Long id){
        log.debug("Get products by ID");
        return new ResponseEntity<ProductDto>(productService.getProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        log.debug("Delete products by Id");
        return new ResponseEntity<>(productService.removeProduct(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto){
        log.debug("Updates Product");
        return new ResponseEntity<>(productService.updateProduct(productDto),HttpStatus.OK);
    }



}
