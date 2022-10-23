package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableDetail;

public interface TableDetailService {

public List<TableDetail> getAll();
	
	public TableDetail get(int tableDetailId);
	
	public void save(TableDetail tableDetail);
	
	public void delete(int tableDetailId);
	
}
