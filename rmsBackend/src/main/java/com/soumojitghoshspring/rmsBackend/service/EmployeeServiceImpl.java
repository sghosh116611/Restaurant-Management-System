package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.EmployeeDAO;
import com.soumojitghoshspring.rmsBackend.entity.Employee;
import com.soumojitghoshspring.rmsBackend.service.intrface.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll(Optional<List<String>> sort, String order) {
		return employeeDAO.findAll(sort, order);
	}

	@Override
	@Transactional
	public Employee findEmployee(int employeeId) {
		return employeeDAO.findEmployee(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void delete(int employeeId) {
		employeeDAO.delete(employeeId);
	}

}
