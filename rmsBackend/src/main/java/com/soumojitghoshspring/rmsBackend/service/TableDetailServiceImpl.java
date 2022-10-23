package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableDetailDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableDetail;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableDetailService;

@Service
public class TableDetailServiceImpl implements TableDetailService {

	@Autowired
	TableDetailDAO tableDetailDAO;
	
	@Override
	@Transactional
	public List<TableDetail> getAll() {
		return tableDetailDAO.getAll();
	}

	@Override
	@Transactional
	public TableDetail get(int tableDetailId) {
		return tableDetailDAO.get(tableDetailId);
	}

	@Override
	@Transactional
	public void save(TableDetail tableDetail) {
		tableDetailDAO.save(tableDetail);
	}

	@Override
	@Transactional
	public void delete(int tableDetailId) {
		tableDetailDAO.delete(tableDetailId);
	}

}
