package com.smart.vendor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    private String customerName;
    private Long customerNumber;
    private List<Product> products;
    private Double price;
    private Integer estimateTime;
}
