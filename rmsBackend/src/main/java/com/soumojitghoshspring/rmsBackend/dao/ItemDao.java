package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.Item;

public interface ItemDao {

	public List<Item> findAll(); 
}
