package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.OrderDAO;
import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Order> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Order> query = currentSession.createQuery("from Order", Order.class);
		
		List<Order> orders = query.getResultList();
		System.out.println("Query executed");
		
		return orders;
	}

	@Override
	public Order get(int orderId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Order order =  currentSession.get(Order.class, orderId);
		
		return order;
	}

	@Override
	public void save(Order order) {
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println(order.toString());
		currentSession.save(order);
	}
	

}
