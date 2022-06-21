package com.smart.vendor.model;

import com.smart.vendor.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto  {
    private Long orderId;
    private String customerName;
    private Long customerNumber;
    private List<Product> products;
    private Double price;
    private Integer estimateTime;
}
