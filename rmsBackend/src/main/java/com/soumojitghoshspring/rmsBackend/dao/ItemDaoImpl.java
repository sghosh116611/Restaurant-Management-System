package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.OrderBy;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.exceptions.NoFoodItemFoundException;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Item> findAll(Optional<List<String>> sort, String order) {

		Session currentSession = entityManager.unwrap(Session.class);

		String orderByQuery = " order by id";

		if (sort.isPresent()) {
			orderByQuery = " order by ";
			List<String> sortParameters = sort.get();
			for (int i = 0; i < sortParameters.size(); i++) {
				orderByQuery += sortParameters.get(i) + (i != sortParameters.size() - 1 ? "," : "");
			}
		}

		orderByQuery += " " + order;

		String findQuery = "from Item where isActive=1" + orderByQuery;

		System.out.println(findQuery);

		Query<Item> query = currentSession.createQuery(findQuery, Item.class);

		List<Item> items = query.getResultList();

		return items;
	}

	@Override
	public Item findItem(int itemId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Item item = currentSession.get(Item.class, itemId);

		if (item == null) {
			throw new NoFoodItemFoundException("No Item found with ID : " + itemId);
		}

		return item;
	}

	@Override
	public void save(Item item) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(item);
	}

	@Override
	public void delete(int itemId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Item item = this.findItem(itemId);

		Query<Item> query = currentSession.createQuery("delete from Item where id=:itemId");
		query.setParameter("itemId", itemId);

		query.executeUpdate();
	}

}
