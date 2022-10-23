package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableBook;

public interface TableBookDAO {

	public List<TableBook> getAll();
	
	public TableBook get(int tableBookId);
	
	public void save(TableBook tableBook);
	
	public void delete(int tableBookId);
	
}
