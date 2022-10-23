package com.soumojitghoshspring.rmsBackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.ItemDao;
import com.soumojitghoshspring.rmsBackend.dao.intrface.OrderDAO;
import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.entity.Order;
import com.soumojitghoshspring.rmsBackend.service.intrface.ItemService;
import com.soumojitghoshspring.rmsBackend.service.intrface.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	@Transactional
	public List<Order> getAll() {
		return orderDAO.getAll();
	}

	@Override
	@Transactional
	public Order get(int orderId) {
		return orderDAO.get(orderId);
	}

	@Override
	@Transactional
	public void save(Order order) {
		orderDAO.save(order);

	}

}
