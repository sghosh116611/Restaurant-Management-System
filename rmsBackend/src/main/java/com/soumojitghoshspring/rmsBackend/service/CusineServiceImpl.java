package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.CuisineDAO;
import com.soumojitghoshspring.rmsBackend.entity.Cuisine;
import com.soumojitghoshspring.rmsBackend.service.intrface.CuisineService;

@Service
public class CusineServiceImpl implements CuisineService {

	@Autowired
	CuisineDAO cuisineDAO;
	
	@Override
	@Transactional
	public List<Cuisine> findAll() {
		return cuisineDAO.findAll();
	}

	@Override
	@Transactional
	public Cuisine findCuisine(int cuisineId) {
		return cuisineDAO.findCuisine(cuisineId);
	}

	@Override
	@Transactional
	public void save(Cuisine cuisine) {
		cuisineDAO.save(cuisine);
	}

	@Override
	@Transactional
	public void delete(int cuisineId) {
		cuisineDAO.delete(cuisineId);
	}

}
