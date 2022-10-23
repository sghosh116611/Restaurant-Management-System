package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableBookDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableBook;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableBookService;

@Service
public class TableBookServiceImpl implements TableBookService {

	@Autowired
	private TableBookDAO tableBookDAO;
	
	@Override
	@Transactional
	public List<TableBook> getAll() {
		return tableBookDAO.getAll();
	}

	@Override
	@Transactional
	public TableBook get(int tableBookId) {
		return tableBookDAO.get(tableBookId);
	}

	@Override
	@Transactional
	public void save(TableBook tableBook) {
		tableBookDAO.save(tableBook);
	}

	@Override
	@Transactional
	public void delete(int tableBookId) {
		tableBookDAO.delete(tableBookId);
	}

}
