package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.EmployeeTypeDAO;
import com.soumojitghoshspring.rmsBackend.entity.EmployeeType;
import com.soumojitghoshspring.rmsBackend.service.intrface.EmployeeTypeService;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

	@Autowired
	private EmployeeTypeDAO employeeTypeDAO;
	
	@Override
	@Transactional
	public List<EmployeeType> findAll(Optional<List<String>> sort, String order) {
		return employeeTypeDAO.findAll(sort, order);
	}

	@Override
	@Transactional
	public EmployeeType findEmployeeType(int employeeTypeId) {
		return employeeTypeDAO.findEmployeeType(employeeTypeId);
	}

	@Override
	@Transactional
	public void save(EmployeeType employeeType) {
		employeeTypeDAO.save(employeeType);
	}

	@Override
	@Transactional
	public void delete(int employeeTypeId) {
		employeeTypeDAO.delete(employeeTypeId);
	}

}
