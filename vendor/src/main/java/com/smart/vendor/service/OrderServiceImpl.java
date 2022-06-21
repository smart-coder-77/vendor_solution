package com.smart.vendor.service;

import com.smart.vendor.entity.Order;
import com.smart.vendor.exception.OrderIdNotFoundException;
import com.smart.vendor.exception.OrderNotSavedException;
import com.smart.vendor.model.OrderDto;
import com.smart.vendor.repository.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */
@Service
public class OrderServiceImpl implements OrderService{

     @Autowired
     private OrderRepo orderRepo;

    @Override
    public String OrderSave(OrderDto orderDto) {
        if (orderDto.getCustomerNumber()!=null){
            ModelMapper modelMapper = new ModelMapper();
            Order order = modelMapper.map(orderDto, Order.class);
            orderRepo.save(order);
            return "Product "+ orderDto.getCustomerNumber()+"saved successfully";
        }else {
            throw new OrderNotSavedException("Order not created due to technical glitch");
        }
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order= orderRepo.findById(id).orElseThrow(()->new OrderIdNotFoundException("Order"+ id+"Not found Exception"));
        ModelMapper modelMapper = new ModelMapper();
        OrderDto orderDto = modelMapper.map(order,OrderDto.class);
        return orderDto;
    }

    @Override
    public List<OrderDto> getAllOrder() {
        List<Order> orders = orderRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<OrderDto> orderDto = (List<OrderDto>) modelMapper.map(orders,OrderDto.class);
        return orderDto;
    }

    @Override
    public String removeOrder(Long id) {
        OrderDto orderDto= getOrderById(id);
        orderRepo.deleteById(orderDto.getOrderId());
        return "Order"+id+"Removed successfully";
    }

    @Override
    public String updateOrder(OrderDto order) {
        OrderDto orderDto= getOrderById(order.getOrderId());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setCustomerNumber(order.getCustomerNumber());
        orderDto.setProducts(order.getProducts());
        orderDto.setPrice(order.getPrice());
        ModelMapper modelMapper = new ModelMapper();
        Order order1 = modelMapper.map(orderDto, Order.class);
        orderRepo.save(order1);
        return "Product "+ order.getCustomerNumber()+ " Updated successfully";
    }
}
