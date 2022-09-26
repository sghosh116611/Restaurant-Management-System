package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.ItemDao;
import com.soumojitghoshspring.rmsBackend.entity.FoodType;
import com.soumojitghoshspring.rmsBackend.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;

	@Override
	@Transactional
	public List<Item> findAll(Optional<List<String>> sort, String order) {
		return itemDao.findAll(sort,order);
	}

	@Override
	@Transactional
	public Item findItem(int itemId) {
		return itemDao.findItem(itemId);
	}

	@Override
	@Transactional
	public void save(Item item) {
		itemDao.save(item);
	}

	@Override
	@Transactional
	public void delete(int itemId) {
		itemDao.delete(itemId);
	}

}
