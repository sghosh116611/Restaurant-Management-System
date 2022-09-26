package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Item> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Item> query = currentSession.createQuery("from Item", Item.class);

		List<Item> items = query.getResultList();

		return items;
	}

}
