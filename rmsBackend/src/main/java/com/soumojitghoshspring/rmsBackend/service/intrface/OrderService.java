package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.Order;

public interface OrderService {

	public List<Order> getAll();

	public Order get(int orderId);

	public void save(Order order);

}
