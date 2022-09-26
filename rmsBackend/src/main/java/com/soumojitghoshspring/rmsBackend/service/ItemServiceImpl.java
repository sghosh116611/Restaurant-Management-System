package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.ItemDao;
import com.soumojitghoshspring.rmsBackend.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	@Override
	@Transactional
	public List<Item> findAll() {
		return itemDao.findAll();
	}

}
