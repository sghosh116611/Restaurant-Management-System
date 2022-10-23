package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableDetail;
import com.soumojitghoshspring.rmsBackend.entity.TableType;

public interface TableDetailDAO {

	public List<TableDetail> getAll();
	
	public TableDetail get(int tableDetailId);
	
	public void save(TableDetail tableDetail);
	
	public void delete(int tableDetailId);
	
}
