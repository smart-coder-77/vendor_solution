package com.smart.vendor.service;

import com.smart.vendor.entity.Product;
import com.smart.vendor.model.ProductDto;

import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */

public interface ProductService {

    String productSave(ProductDto product);
    ProductDto getProductById(Long id);
    List<Product> getAllProduct();
    String removeProduct(Long id);
    String updateProduct(ProductDto product);

}
