package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;
import java.util.Optional;

import com.soumojitghoshspring.rmsBackend.entity.Item;

public interface ItemDao {

	public List<Item> findAll(Optional<List<String>> sort,String order); 
	public Item findItem(int itemId);
	public void save(Item item);
	public void delete(int itemId);
}
