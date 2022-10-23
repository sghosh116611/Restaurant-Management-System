package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.Order;

public interface OrderDAO {

	public List<Order> getAll();
	
	public Order get(int orderId);
	
	public void save(Order order);
}
