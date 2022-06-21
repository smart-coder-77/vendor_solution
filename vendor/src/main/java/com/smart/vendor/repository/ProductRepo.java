package com.smart.vendor.repository;
import com.smart.vendor.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Choudhury Subham on 21-06-2022
 */
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
