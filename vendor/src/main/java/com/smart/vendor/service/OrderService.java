package com.smart.vendor.service;
import com.smart.vendor.entity.Order;
import com.smart.vendor.model.OrderDto;

import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */

public interface OrderService {

    String OrderSave(OrderDto order);
    OrderDto getOrderById(Long id);
    List<OrderDto> getAllOrder();
    String removeOrder(Long id);
    String updateOrder(OrderDto order);
}
