package com.soumojitghoshspring.rmsBackend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.CuisineDAO;
import com.soumojitghoshspring.rmsBackend.entity.Cuisine;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class CuisineDAOImpl implements CuisineDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Cuisine> findAll() {
		List<Cuisine> cuisines = new ArrayList<>();

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Cuisine> query = currentSession.createQuery("from Cuisine", Cuisine.class);
		cuisines = query.getResultList();

		return cuisines;
	}

	@Override
	public Cuisine findCuisine(int cuisineId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Cuisine cuisine = currentSession.get(Cuisine.class, cuisineId);

		if (cuisine == null) {
			throw new GenericCustomException("No cuisine found with id:" + cuisineId);
		}

		return cuisine;
	}

	@Override
	public void save(Cuisine cuisine) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(cuisine);

	}

	@Override
	public void delete(int cuisineId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Cuisine cuisine = this.findCuisine(cuisineId);

		Query<Cuisine> query = currentSession.createQuery("delete from Cuisine where id=:cuisineId");
		query.setParameter("cuisineId", cuisineId);
		
		query.executeUpdate();
	}

}
