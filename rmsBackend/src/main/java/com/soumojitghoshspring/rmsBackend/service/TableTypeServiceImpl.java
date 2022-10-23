package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableTypeDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableType;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableTypeService;

@Service
public class TableTypeServiceImpl implements TableTypeService {

	@Autowired	
	TableTypeDAO tableTypeDAO;
	
	@Override
	@Transactional
	public List<TableType> getAll() {
		return tableTypeDAO.getAll();
	}

	@Override
	@Transactional
	public TableType get(int tableTypeId) {
		return tableTypeDAO.get(tableTypeId);
	}

	@Override
	@Transactional
	public void save(TableType tableType) {
		tableTypeDAO.save(tableType);
	}

	@Override
	@Transactional
	public void delete(int tableTypeId) {
		tableTypeDAO.delete(tableTypeId);
	}

}
