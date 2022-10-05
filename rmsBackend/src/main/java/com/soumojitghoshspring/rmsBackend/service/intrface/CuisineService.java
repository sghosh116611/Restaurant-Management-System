package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;
import java.util.Optional;

import com.soumojitghoshspring.rmsBackend.entity.Cuisine;
import com.soumojitghoshspring.rmsBackend.entity.Employee;

public interface CuisineService {
	public List<Cuisine> findAll();

	public Cuisine findCuisine(int cuisineId);

	public void save(Cuisine cuisine);

	public void delete(int cuisineId);
}
