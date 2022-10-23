package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.TableBook;

public interface TableBookService {
	public List<TableBook> getAll();

	public TableBook get(int tableBookId);

	public void save(TableBook tableBook);

	public void delete(int tableBookId);
}
