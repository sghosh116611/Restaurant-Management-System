package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableType;

public interface TableTypeDAO {
public List<TableType> getAll();
	
	public TableType get(int tableTypeId);
	
	public void save(TableType tableType);
	
	public void delete(int tableTypeId);
}
