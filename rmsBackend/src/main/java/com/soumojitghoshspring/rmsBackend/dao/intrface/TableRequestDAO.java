package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableRequest;

public interface TableRequestDAO {

	public List<TableRequest> getAll();
	
	public TableRequest get(int tableRequestId);
	
	public void save(TableRequest tableRequest);
	
	public void delete(int tableRequestId);
	
}
