package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;
import java.util.Optional;

import com.soumojitghoshspring.rmsBackend.entity.EmployeeType;


public interface EmployeeTypeService {

	public List<EmployeeType> findAll(Optional<List<String>> sort, String order);

	public EmployeeType findEmployeeType(int employeeTypeId);

	public void save(EmployeeType employeeTypeId);

	public void delete(int employeeTypeId);
	
}
