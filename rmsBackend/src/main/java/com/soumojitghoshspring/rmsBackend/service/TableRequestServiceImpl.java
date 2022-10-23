package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableRequestDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableRequest;
import com.soumojitghoshspring.rmsBackend.service.intrface.TableRequestService;

@Service
public class TableRequestServiceImpl implements TableRequestService {

	@Autowired
	private TableRequestDAO tableRequestDAO;
	
	@Override
	@Transactional
	public List<TableRequest> getAll() {
		return tableRequestDAO.getAll();
	}

	@Override
	@Transactional
	public TableRequest get(int tableRequestId) {
		return tableRequestDAO.get(tableRequestId);
	}

	@Override
	@Transactional
	public void save(TableRequest tableRequest) {
		tableRequestDAO.save(tableRequest);
	}

	@Override
	@Transactional
	public void delete(int tableRequestId) {
		tableRequestDAO.delete(tableRequestId);

	}

}
