package com.smart.vendor.repository;
import com.smart.vendor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Choudhury Subham on 21-06-2022
 */
@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}
