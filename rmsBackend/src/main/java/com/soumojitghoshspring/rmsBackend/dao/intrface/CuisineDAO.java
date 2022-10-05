package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.Cuisine;

public interface CuisineDAO {
	public List<Cuisine> findAll();

	public Cuisine findCuisine(int cuisineId);

	public void save(Cuisine cuisine);

	public void delete(int cuisineId);
}
