package com.smart.vendor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Choudhury Subham on 21-06-2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productId;
    private String productName;
    private Double productPrice;

}
